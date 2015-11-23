

		function ContentSize(size)
		{
			var obj=document.getElementById("BodyLabel");
			obj.style.fontSize=size+"px";
		}	
		function fetch_object(idname)
		{
 			var my_obj = document.getElementById(idname);
 			return my_obj;
		}
		function show_sub(obj)
		{
			var content_detail = fetch_object("content_detail_" + obj);
  			var show_content = fetch_object("show_content_" + obj);
  			if (content_detail.style.display == "block")
  			{
  				 content_detail.style.display="none";
   				 show_content.innerHTML="+";
  			}
  			else
  			{
  				content_detail.style.display="block";
  				show_content.innerHTML="-";
 		    }
		}