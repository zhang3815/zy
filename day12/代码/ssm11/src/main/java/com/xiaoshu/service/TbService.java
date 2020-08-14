package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.TbmajordayMapper;
import com.xiaoshu.dao.TbstudayMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.TbVo;
import com.xiaoshu.entity.Tbmajorday;
import com.xiaoshu.entity.Tbstuday;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class TbService {

/*	@Autowired
	UserMapper userMapper;

	// 查询所有
	public List<User> findUser(User t) throws Exception {
		return userMapper.select(t);
	};

	// 数量
	public int countUser(User t) throws Exception {
		return userMapper.selectCount(t);
	};

	// 通过ID查询
	public User findOneUser(Integer id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	};

	// 新增
	public void addUser(User t) throws Exception {
		userMapper.insert(t);
	};

	// 修改
	public void updateUser(User t) throws Exception {
		userMapper.updateByPrimaryKeySelective(t);
	};

	// 删除
	public void deleteUser(Integer id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
	};

	// 登录
	public User loginUser(User user) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(user.getPassword()).andUsernameEqualTo(user.getUsername());
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过用户名判断是否存在，（新增时不能重名）
	public User existUserWithUserName(String userName) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过角色判断是否存在
	public User existUserWithRoleId(Integer roleId) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}
*/
	@Autowired
	private TbstudayMapper tbstudayMapper;
	public PageInfo<TbVo> findUserPage(TbVo tbVo, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<TbVo> userList = tbstudayMapper.findPage(tbVo);
		PageInfo<TbVo> pageInfo = new PageInfo<TbVo>(userList);
		return pageInfo;
	}
	@Autowired
	private TbmajordayMapper tbmajordayMapper;
	public List<Tbmajorday> findAll() {
		// TODO Auto-generated method stub
		return tbmajordayMapper.selectAll();
	}
	// 新增
		public void addUser(Tbstuday t) throws Exception {
			tbstudayMapper.insert(t);
		};

		// 修改
		public void updateUser(Tbstuday t) throws Exception {
			tbstudayMapper.updateByPrimaryKeySelective(t);
		};

		// 删除
		public void deleteUser(Integer id) throws Exception {
			tbstudayMapper.deleteByPrimaryKey(id);
		}
		public List<TbVo> findpage(TbVo tbVo) {
			// TODO Auto-generated method stub
			return tbstudayMapper.findPage(tbVo);
		}
		public List<TbVo> getEcharts() {
			
			return tbstudayMapper.getEcharts();
		};

}
