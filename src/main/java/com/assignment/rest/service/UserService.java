package com.assignment.rest.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assignment.rest.domain.User;
import com.assignment.rest.repository.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll().stream().sorted(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				if (o1.getDateOfBirth() != null && o2.getDateOfBirth() != null) {
					Date date1 = convertStringToDate(o1.getDateOfBirth());
					Date date2 = convertStringToDate(o2.getDateOfBirth());
					return date1.compareTo(date2);
				} else {
					return +1;
				}

			}
		}).collect(Collectors.toList());
	}

	public User getUserByUserId(String userId) {
		Optional<User> userop = userRepository.findById(userId);
		if (userop.isPresent()) {
			return userop.get();
		} else {
			throw new RuntimeException("Invalid user id.");
		}
	}

	public User updateUserDetails(User user) {
		User savedUser = getUserByUserId(user.getUserId());
		savedUser.setUserName(user.getUserName());
		savedUser.setDateOfBirth(user.getDateOfBirth());
		return saveUser(savedUser);
	}

	public void deleteUser(String userId) {
		userRepository.deleteById(userId);
	}

	public Date convertStringToDate(String str) {
		Date date = new Date();
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			date = dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
