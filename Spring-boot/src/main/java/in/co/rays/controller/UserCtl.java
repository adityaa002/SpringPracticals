package in.co.rays.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.co.rays.common.BaseCtl;
import in.co.rays.common.ORSResponse;
import in.co.rays.dto.AttatchmentDTO;
import in.co.rays.dto.UserDTO;
import in.co.rays.form.UserForm;
import in.co.rays.service.AttatchmentServiceInt;
import in.co.rays.service.UserServiceInt;

@RestController
@RequestMapping("User")
public class UserCtl extends BaseCtl {

	@Autowired
	public UserServiceInt userService;

	@Autowired
	public AttatchmentServiceInt attatchmentService;

	@PostMapping("/save")
	public ORSResponse save(@RequestBody @Valid UserForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = (UserDTO) form.getDto();
		long pk = userService.add(dto);

		res.addData(pk);
		res.addMessage("User registered Successfully..!");

		return res;

	}

	@PostMapping("/update")
	public ORSResponse update(@RequestBody @Valid UserForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = (UserDTO) form.getDto();
		userService.update(dto);

		res.addMessage("Record Updated Successfully...!");
		return res;

	}

	@GetMapping("/get/{id}")
	public ORSResponse get(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		if (id == 0) {
			res.addMessage("Id is required to search record..!");
			return res;
		}

		UserDTO dto = userService.findByPk(id);

		res.addData(dto);
		res.setSuccess(true);
		return res;

	}

	@PostMapping("/delete/{ids}")
	public ORSResponse delete(@PathVariable Long[] ids) {

		ORSResponse res = new ORSResponse();

		if (ids == null) {
			res.addMessage("Id is required to delete a record..!");
			return res;
		}

		for (long id : ids) {
			userService.delete(id);
		}
		res.setSuccess(true);
		res.addMessage("Record deleted Successfully..!");
		return res;

	}

	@PostMapping("search/{pageNo}")
	public ORSResponse search(@RequestBody UserForm form, @PathVariable int pageNo) {

		ORSResponse res = new ORSResponse();

		UserDTO dto = (UserDTO) form.getDto();

		List list = userService.search(dto, pageNo, 10);

		if (list == null && list.size() == 0) {
			res.addMessage("No records found");
			return res;
		}

		res.addData(list);
		res.setSuccess(true);
		return res;

	}

	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		AttatchmentDTO attachmentDto = new AttatchmentDTO(file);

		attachmentDto.setDescription("profile picture");
		attachmentDto.setUserId(userId);

		UserDTO userDto = userService.findByPk(userId);

		if (userDto.getImageId() != null && userDto.getImageId() > 0) {
			attachmentDto.setId(userDto.getImageId());
		}

		Long imageId = attatchmentService.add(attachmentDto);

		if (userDto.getImageId() == null) {
			userDto.setImageId(imageId);
			userService.update(userDto);
		}
		ORSResponse res = new ORSResponse();

		res.addResult("imageId", imageId);
		res.setSuccess(true);

		return res;

	}

	@GetMapping("/profilePic/{userId}")
	public @ResponseBody void downloadPic(@PathVariable Long userId, HttpServletResponse response) {

		try {
			UserDTO dto = userService.findByPk(userId);

			AttatchmentDTO attatchmentDto = null;

			if (dto != null) {
				attatchmentDto = attatchmentService.findByPk(dto.getImageId());
 			}

			if (attatchmentDto != null) {
				
				System.out.println("attDto is not null");

				response.setContentType(attatchmentDto.getType());
				OutputStream out = response.getOutputStream();

				out.write(attatchmentDto.getDoc());

				out.close();

			} else {
				response.getWriter().write("ERROR : FILE NOT FOUND");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
