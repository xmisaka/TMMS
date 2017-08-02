package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MenuitemMapper;
import entity.Menuitem;
import service.MenuitemService;

@Service
public class MenuitemServiceImpl implements MenuitemService {

	@Autowired
	MenuitemMapper menuitemMapper;
	
	@Override
	public int editMenuitem(Menuitem menuitem) {
		// TODO Auto-generated method stub
		return menuitemMapper.updateByPrimaryKeySelective(menuitem);
	}

	@Override
	public int insertMenuitem(Menuitem menuitem) {
		// TODO Auto-generated method stub
		return menuitemMapper.insertSelective(menuitem);
	}

	@Override
	public int deleteMenuitem(int id) {
		// TODO Auto-generated method stub
		return menuitemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteMenuitems(int[] ids) {
		// TODO Auto-generated method stub
       for(int id:ids){
    	   menuitemMapper.deleteByPrimaryKey(id);
       }
	}

	@Override
	public Menuitem getMenuitemByID(int id) {
		// TODO Auto-generated method stub
		return menuitemMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Menuitem> selectByParentId(int parentId) {
		// TODO Auto-generated method stub
		return menuitemMapper.selectByParentId(parentId);
	}

}
