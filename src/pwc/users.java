package pwc;

import java.util.*;




class users {
	String email;
	String mobile;
	String type;
	String stat="Active";
	
	 List create(String a, String z, String y) {
		if(a=="e") {
			this.email = z;
		}
		else if (a=="m") {
			this.mobile = z;
		}
		this.type = y;
		this.stat = "Active";
		ArrayList<String> x = new ArrayList<String>();
		x.addAll(new ArrayList<String>(Arrays.asList(z,y,this.stat)));
		
		return x;
	}
	 
	 
	 ArrayList display(ArrayList li) {
		 List listr = new ArrayList<String>();
         listr.add("Regular:");
         List listp = new ArrayList<String>();
         listp.add("Premium:");
		 for (int i = 0; i < li.size(); i++) {
	            
	            List lis = (List) li.get(i);
	            
	            
	            if(lis.get(1)=="Regular") {
	            	listr.add(lis);
	            }
	            else if(lis.get(1)=="Premium") {
	            	listp.add(lis);
	            }
	            
	            
	            
	    }
		 ArrayList flist = new ArrayList<String>();
         flist.add(listr);
         flist.add(listp);
			return flist;
		}
	 
	 
	 ArrayList update(ArrayList li, String z, String y) {
		
		 for (int i = 0; i < li.size(); i++) {
	            
	            List lis = (List) li.get(i);
	            if(lis.get(0)==z) {
	            	lis.set(1, y);
	            }
	            li.set(i, lis);
	            
	    }
			
			return li;
		}
	 
	 
	 
	 ArrayList delete(ArrayList li, String z, String y) {
			
		 for (int i = 0; i < li.size(); i++) {
	            
	            List lis = (List) li.get(i);
	            if(lis.get(0)==z) {
	            	lis.set(2,"Inactive");
	            }
	            li.set(i, lis);
	            
	    }
			
			return li;
		}

	
}
