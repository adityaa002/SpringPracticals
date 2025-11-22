package in.co.rays.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.rays.common.BaseCtl;
import in.co.rays.common.ORSResponse;
import in.co.rays.dto.RoleDTO;
import in.co.rays.form.RoleForm;
import in.co.rays.service.RoleServiceInt;

@RestController
@RequestMapping("Role")
public class RoleCtl extends BaseCtl {

	@Autowired
	public RoleServiceInt roleService;

	@PostMapping("save")
	public ORSResponse save(@RequestBody @Valid RoleForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		RoleDTO dto = (RoleDTO) form.getDto();

		long pk = roleService.add(dto);

		res.addData(pk);

		res.addMessage("Role Added Succesfully...!");

		return res;

	}

	@PostMapping("update")
	public ORSResponse update(@RequestBody @Valid RoleForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		RoleDTO dto = (RoleDTO) form.getDto();
		roleService.update(dto);

		res.addData(dto);
		res.addMessage("Role updated successfully...!");

		return res;

	}

	@PostMapping("delete/{ids}")
	public ORSResponse delete(@PathVariable long[] ids) {

		ORSResponse res = new ORSResponse();

		for (long id : ids) {
			roleService.delete(id);
		}

		res.addMessage("data deleted successfully");
		res.setSuccess(true);

		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse findBypk(@PathVariable long id) {

		ORSResponse res = new ORSResponse();

		RoleDTO dto = roleService.findByPk(id);

		if (dto != null) {
			res.setSuccess(true);
		}
		res.addData(dto);

		return res;
	}

	@PostMapping("search/{pageNo}")
	public ORSResponse search(@RequestBody RoleForm form, @PathVariable int pageNo) {

		ORSResponse res = new ORSResponse();

		RoleDTO dto = (RoleDTO) form.getDto();

		List list = roleService.search(dto, pageNo, 1);

		if (list != null && list.size() > 0) {

			res.setSuccess(true);

		}

		res.addData(list);

		return res;

	}

}
