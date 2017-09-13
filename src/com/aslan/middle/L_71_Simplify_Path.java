/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/


public String simplifyPath(String path) {
		String[] pathArray=path.split("/");
		int length=pathArray.length;
		Stack< String> stack=new Stack<>();
		String result="";
		for(int i=0;i<length;i++){
			if(pathArray[i].equals("")||pathArray[i].equals(".")){
				continue;
			}
			else if(pathArray[i].equals(".."))
			{
				if(!stack.isEmpty()){
					stack.pop();
				}
				
			}
			else {
				stack.push(pathArray[i]);
			}
		}
		if(stack.isEmpty())
			return "/";
		while(!stack.isEmpty())
		{
		result="/"+stack.pop()+result;
		}
		
		return result;
        
    }
