public class User{ 
	private ArrayList<Integer> friends; 
	private ArrayList<Integer> pictures; 
	private int userID; 
	private int machineID; 
	private String information; 
	private Server server = new Server(); 
	private Storage storage = new Storage(); 

	public User(int userID, int machineID){ 
		this.userID = userID; 
		this.machineID = machineID; 
pictures = new ArrayList<Integer>(); 
friends = new ArrayList<Integer>(); 
	} 

	public String getInformation() { 
		return information; 
	} 

	public void setInformation(String information){ 
		this.information = information; 
	} 

	public getID(){ 
		return userID; 
	} 

	public int getMachineID(){ 
		return machineID; 
	} 

	public void addFriend(int id){ 
		friends.add(i); 
	} 

	public void addPicture(int id){ 
		pictures.add(i); 
	} 

	public int[] getFriends(){ 
		int[] temp = new int[friends.size()]; 
		for(int i=0; i<temp.length; i++){ 
			temp[i] = friends.get(i); 
		} 
		return temp; 
	} 

	public int[] getPictures(){ 
		int[] temp = new int[pictures.size()]; 
		for(int i=0; i<temp.length; i++){ 
			temp[i] = pictures.get(i); 
		} 
		return temp; 
	} 

	public User lookUpFriend(int machineID, int ID){ 
		for(Machine m : server.machine){ 
			if(m.machineID = machineID){ 
				for(User user : m.users){ 
					if(user.userID = ID){ 
						return user; 
					} 
				} 
			} 
		} 
		return null; 
	} 

	public Picture lookUpPicture(int machineID, int ID){ 
		for(StorageMachine m : storage.machine){ 
			if(m.machineID = machineID){ 
				for(Picture picture : m.pictures){ 
					if(picture.pictureID = ID){ 
						return picture; 
					} 
				} 
			} 
		} 
		return null; 
	} 
} 
public class Picture{ 
	private int machineID; 
	private int pictureID; 
	private String photoPath; 

	public Picture(int machineID, int pictureID, String photoPath){ 
		this.machineID = machineID; 
		this.pictureID = pictureID; 
		this.photoPath = photoPath; 
	} 

	public int getMachineID(){ 
		return machineID; 
	} 

	public void setMachineID(int machineID){ 
		this.machineID = machineID; 
	} 

	public int getPictureID(){ 
		return pictureID; 
	} 

	public int getPhotoPath(){ 
		return photoPath; 
	} 

	public void setPhotoPath(String photoPath){ 
		this.photoPath = photoPath; 
	} 
} 
