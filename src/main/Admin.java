package main;

import java.util.LinkedList;
import java.util.ArrayList;

public class Admin extends Welcome {
	
	private LinkedList<Artist> artistList = new LinkedList<>();
	private LinkedList<Art> artList = new LinkedList<>();
	
	Admin() {
		System.out.print("Enter Admin Name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter Admin Password: ");
		String pw = sc.nextLine();
		
		if(name.equals("Admin") && pw.equals("admin!@#")) {
			adminWelcome();			
		} else {
			System.out.println("Invalid username and password");
			new Admin();
		}
	}
	
	private void adminWelcome() {
		switch(adminWelcomeOption()) {
			case 1: addArtist(); break;
			case 2: updateArtist(); break;
			case 3: deleteArtist(); break;
			case 4: addArt(); break;
			case 5: deleteArt(); break;
			case 6: ; break;
			case 7: ; break;
			case 8: welcome(); break;
		}
	}
	
	private void addArtist() {
		Artist artist;
		char status;
		do {
			artist = new Artist();
			if(artistList.isEmpty())
				artist.setArtistNo(1);
			else 
				artist.setArtistNo(artistList.getLast().getArtistNo() + 1);
			
			System.out.print("Artist name: ");
			artist.setName(sc.nextLine());
			
			boolean addressStatus = false;
			while(!addressStatus) {
				try {
					System.out.print("Artist address (Town, Township): ");
					String address = sc.nextLine();
					
					if(check.checkArtistAddress(address)) {
						artist.setAddress(address);
						addressStatus = true;
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			boolean phStatus = false;
			while(!phStatus) {
				try {
					System.out.println("Artist phone number: ");
					String phNo = sc.next();
					
					if(check.checkPhNo(phNo)) {
						artist.setPhNo(phNo);
						phStatus = true;
					}
						
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			artistList.add(artist);
			
			System.out.print("Add another artist? y/n: ");
			status = sc.next().charAt(0);
			sc.nextLine();
		} while(status != 'n');
		
		viewArtist();
		adminWelcome();
	}
	
	private void updateArtist() {
		char status;
		do {
			System.out.print("Artist name: ");
			String name = sc.nextLine();
			
			boolean found = false;
			for(Artist artist: artistList) {
				if(artist.getName().equalsIgnoreCase(name)) {
					System.out.println(artist.getArtistNo() + "\t" + artist.getName() + "\t\t" + artist.getAddress() + "\t" + artist.getPhNo());
					boolean addressStatus = false;
					while(!addressStatus) {
						try {
							System.out.print("Artist address (Town, Township): ");
							String address = sc.nextLine();
							
							if(check.checkArtistAddress(address)) {
								artist.setAddress(address);
								addressStatus = true;
							}
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					
					boolean phStatus = false;
					while(!phStatus) {
						try {
							System.out.println("Artist phone number: ");
							String phNo = sc.next();
							
							if(check.checkPhNo(phNo)) {
								artist.setPhNo(phNo);
								phStatus = true;
							}
								
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					System.out.println("Artist Updated Successfully.");
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("There is no artist with such name.");
			
			System.out.print("Update another artist? y/n: ");
			status = sc.next().charAt(0);
			sc.nextLine();
		} while(status != 'n');
		
		adminWelcome();
	}
	
	private void deleteArtist() {
		char status;
		do {
			System.out.print("Artist name: ");
			String name = sc.nextLine();
			
			boolean found = false;
			for(Artist artist: artistList) {
				if(artist.getName().equalsIgnoreCase(name)) {
					System.out.println(artist.getArtistNo() + "\t" + artist.getName() + "\t\t" + artist.getAddress() + "\t" + artist.getPhNo());
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					boolean artPresent = false;
					for(Art art: artList) {
						if(artist.getName().equals(art.getArtistName())) {
							String tag;
							if(!art.isSoldout())
								tag = "Sale";
							else
								tag = "Sold Out";
							System.out.println(art.getArtNo() + "\t" + art.getCategory() + "\t" + art.getName() + "\t" + art.getDescription() + "\t" + art.getPrice() + "\t" + art.getArtistName() + "\t" + tag);
							artPresent = true;
						}
					}
					
					if(!artPresent) {
						System.out.print("Are you sure you want to delete the artist? y/n: ");
						if(sc.next().charAt(0) == 'y') {
							artistList.remove(artist);
							System.out.println("Artist Deleted Successfully.");
						} else 
							System.out.println("Artist wasn't deleted.");
							
					} else {
						System.out.print("There are arts of this artist. \nDeleting the artist will also delete the arts. \nAre you sure you want to delete the artist? y/n: ");
						if(sc.next().charAt(0) == 'y') {
							ArrayList<Art> toDelete = new ArrayList<>();
							for(Art art: artList) {
								if(artist.getName().equals(art.getArtistName())) {
									toDelete.add(art);
								}
							}
							for(Art del: toDelete) {
								artList.remove(del);
							}
							artistList.remove(artist);
							System.out.println("Artist Deleted Successfully.");
						} else
							System.out.println("Artist wasn't deleted.");
					}
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("There is no artist with such name.");
			
			System.out.print("Delete another artist? y/n: ");
			status = sc.next().charAt(0);
			sc.nextLine();
		} while(status != 'n');
		
		adminWelcome();
	}
	
	private void viewArtist() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("                           List of Artists                           ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(Artist artist: artistList) {
			System.out.println(artist.getArtistNo() + "\t" + artist.getName() + "\t\t" + artist.getAddress() + "\t" + artist.getPhNo());
		}
	}
	
	private void addArt() {
		Art art;
		char status;
		do {
			art = new Art();
			
			System.out.print("Artist name: ");
			String name = sc.nextLine();
			
			boolean found = false;
			for(Artist artist: artistList) {
				if(artist.getName().equalsIgnoreCase(name)) {
					
					if(artList.isEmpty())
						art.setArtNo(1);
					else 
						art.setArtNo(artList.getLast().getArtNo() + 1);
					
					boolean catStatus = false;
					while(!catStatus) {
						try {
							System.out.print("Choose category (Potrait, Landscape, Realism, Action, Abstract or Modern): ");
							String category = sc.next();
							
							if(check.checkCategory(category)) {
								art.setCategory(category);
								catStatus = true;
							}
								
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					
					sc.nextLine();
					System.out.print("Art name: ");
					art.setName(sc.nextLine());
					
					System.out.print("Art Description: ");
					art.setDescription(sc.nextLine());
					
					boolean priceStatus = false;
					while(!priceStatus) {
						try {
							System.out.print("Art price: ");
							String price = sc.next();
							
							if(check.checkPrice(price)) {
								art.setPrice(Float.parseFloat(price));
								priceStatus = true;
							}
								
						} catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					

					art.setArtistName(artist.getName());
					
					art.setSoldout(false);					
					
					artList.add(art);
					
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("There is no artist with such name. \nPlease add artist first before adding an art.");
			
			System.out.print("Add another art? y/n: ");
			status = sc.next().charAt(0);
			sc.nextLine();
		} while(status != 'n');
		
		viewArt();
		adminWelcome();
	}

	private void deleteArt() {
		char status;
		do {
			System.out.print("Art name: ");
			String name = sc.nextLine();
			
			boolean found = false;
			for(Art art: artList) {
				if(art.getName().equalsIgnoreCase(name)) {
					String tag;
					if(!art.isSoldout())
						tag = "Sale";
					else
						tag = "Sold Out";
					System.out.println(art.getArtNo() + "\t" + art.getCategory() + "\t" + art.getName() + "\t" + art.getDescription() + "\t" + art.getPrice() + "\t" + art.getArtistName() + "\t" + tag);
				
					System.out.print("Are u srue you want to delete this art? y/n: ");
					if(sc.next().charAt(0) == 'y')
						artList.remove(art);
					System.out.println("Art Deleted Successfully.");
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("There is no art with such name.");
			
			System.out.print("Delete another art? y/n: ");
			status = sc.next().charAt(0);
			sc.nextLine();
		} while(status != 'n');
		
		adminWelcome();
	}
	
	private void viewArt() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("                                     List of Arts                                     ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(Art art: artList) {
			String tag;
			if(!art.isSoldout())
				tag = "Sale";
			else
				tag = "Sold Out";
			System.out.println(art.getArtNo() + "\t" + art.getCategory() + "\t" + art.getName() + "\t" + art.getDescription() + "\t" + art.getPrice() + "\t" + art.getArtistName() + "\t" + tag);
		}
	}
	
	public LinkedList<Artist> getArtistList() {
		return artistList;
	}
	
	public LinkedList<Art> getArtList() {
		return artList;
	}
}
