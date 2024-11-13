package com.example.pharmassist.PharmassistApi.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pharmassist.PharmassistApi.repository.AdminRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final AdminRepository adminrespository;
	

	public UserDetailsServiceImpl(AdminRepository adminrespository) {
		super();
		this.adminrespository = adminrespository;
	}


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return adminrespository.findByEmail(userName)
		.map(UserDetailsImpl::new)
		.orElseThrow(()-> new UsernameNotFoundException("Failed to Authentication User"));
	}

}
