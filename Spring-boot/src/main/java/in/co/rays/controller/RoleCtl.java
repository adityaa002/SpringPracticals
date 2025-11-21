package in.co.rays.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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

	@PostMapping("delete")
	public ORSResponse delete(@RequestBody long id) {

		ORSResponse res = new ORSResponse(true);

		if (id == 0) {

			res.setSuccess(false);
			res.addMessage("ID is required for delete");
		}

		RoleDTO dto = new RoleDTO();
		dto.setId(id);
		roleService.delete(dto);

		res.addData(dto.getId());
		res.addMessage("Role deleted successfully...!");
		return res;

	}

}
