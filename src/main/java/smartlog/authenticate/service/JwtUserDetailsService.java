package smartlog.authenticate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import smartlog.authenticate.entity.UserPrincipal;
import smartlog.db.entity.OfficerMaster;
import smartlog.db.entity.Role;
import smartlog.officer.dao.OfficerMasterDao;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private OfficerMasterDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		OfficerMaster user = userDao.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
	}
	
	public OfficerMaster save(UserPrincipal user) {
		OfficerMaster newUser = new OfficerMaster();
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setOfficerType(user.getOfficerType());
		newUser.setPhoneNo(user.getPhoneNo());
		Long roleId = new Long(2);
		Role role = new Role(roleId);
		newUser.setRole(role);
		return userDao.createOfficer(newUser);
	}
}