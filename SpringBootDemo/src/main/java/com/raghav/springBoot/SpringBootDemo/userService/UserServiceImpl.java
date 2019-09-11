package com.raghav.springBoot.SpringBootDemo.userService;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.raghav.springBoot.SpringBootDemo.model.User;

@Service
public class UserServiceImpl implements UserService {

	public static List<User> userList = new ArrayList<User>();

	static {
		User user1 = new User();
		user1.setId(IdGeneration.getId());
		user1.setName("raghav");
		user1.setDob(new GregorianCalendar(1987, 3, 22).getTime());

		User user2 = new User();
		user2.setId(IdGeneration.getId());
		user2.setName("sunil");
		user2.setDob(new GregorianCalendar(1977, 4, 14).getTime());

		User user3 = new User();
		user3.setId(IdGeneration.getId());
		user3.setName("sandeep");
		user3.setDob(new GregorianCalendar(1985, 8, 23).getTime());

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
	}

	@Override
	public List<User> getAllUsers() {
		return UserServiceImpl.userList;
	}

	public User getUser(int id) {
		for (User user : userList) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User saveUser(User user) {
		if (user != null) {
			user.setId(IdGeneration.getId());
			userList.add(user);
			return user;
		}
		return null;
	}

	public User deleteUser(int id) {
		Iterator<User> itr = UserServiceImpl.userList.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			int currentId = user.getId();
			if (currentId == id) {
				itr.remove();
				return user;
			}
		}

		return null;
	}

	@Override
	public User updateUser(User user) {
		int updationId = user.getId();
		Iterator<User> itr = UserServiceImpl.userList.iterator();
		while (itr.hasNext()) {
			User existsUser = itr.next();
			int existId = existsUser.getId();
			if (updationId == existId) {
				existsUser.setName(user.getName());
				existsUser.setDob(user.getDob());
				return user;
			}
		}
		return null;
	}

	public void customizedMethod() {
		System.out.println("the customized method are presents here");
	}

}
