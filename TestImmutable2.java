package com.clone;

public class TestImmutable2 {
	private static final int sizeInMeg = 200;

	public static void main(String args[]) {
		User share1 = new User("Duke", 10); // 1
		DiskDriveInfo dd = new DiskDriveInfo(sizeInMeg, "myDrive", share1); // 2

		User share = dd.share();
		System.out.println("User with shared access is " + share.userName());

		share1.setUserName("Fred"); // 3
		System.out.println("User with shared access is " + share.userName());
	}
}

final class DiskDriveInfo {
	private final int driveSize;
	private final String volumeLabel;
	private final User driveShare;

	DiskDriveInfo(int size, String volLabel, User share) {
		driveSize = size;
		volumeLabel = volLabel;
		driveShare = (User) share.clone();
	}

	public int size() {
		return driveSize;
	}

	public String label() {
		return volumeLabel;
	}

	public User share() {
		return (User) driveShare.clone();
	}
}

class User implements Cloneable {
	private String userName;
	private String userID;
	private int userNode;

	User(String name, int node) {
		userName = name;
		userNode = node;
	}

	public void setUserName(String name) {
		userName = name;
	}

	public void setUserID(String userid) {
		userID = userid;
	}

	public void setUserNode(int node) {
		userNode = node;
	}

	public String userName() {
		return userName;
	}
	
	protected Object clone()  {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
