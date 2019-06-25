package com.coll.dao;

import com.coll.sections.ProfilePicture;

public interface ProfilePictureDAO {
	public boolean save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);


}
