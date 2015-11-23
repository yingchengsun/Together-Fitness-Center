
	 var Tree = Ext.tree; 
	 Ext.BLANK_IMAGE_URL = 'ext/resources/images/default/s.gif';  
Ext.onReady(function(){  
     var title="'个人资料'";
	 var info2= "'showPIAction!showPersonalInfo.action'";
	 var loginout="'loginOutAction!loginOut.action'";
	 var vport=new Ext.Viewport(  
	       {  
	          enableTabScroll:true,  
	          layout:"border",  
	          items:[ 
	          {
					region: 'north',
					wrap:true, 
					layout : 'fit', 
					autoLoad:'1_mhqx/TopLogo.jsp',
					height: 115,
					minHeight: 115
                }, //---------------顶部logo--------------
	            {  
		          title:"导航菜单",  
		          region:'west',  
		          id:'TreeTitle',  								//-------------------TreeTitle--------------
		          width:200,  
		          collapsible:true,  
		          layoutConfig:{animate:false},  
		          layout:'accordion',  
		          frame:true,//设置导航条样式（圆角）和内部元素padding  
		          bbar: [  ]  
	            },  
	 		     tab   
	            ]  
	         } 
	             
	      );  
//-------------------------------当树形菜单被点击！！！-------------------------------------------------------	      
	  function treeClick(node,e) {  
	      if(node.isLeaf()){  
	         e.stopEvent();  
	         var n = tab.getComponent(node.id);  
	         if (!n) {  
	             var n = tab.add({  
	                 'id' : node.id,  
	                 'title' : node.text, 
	                  
	                 closable:true,  
	                 iconCls:"plugins-nav-icon",  
	                 html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="'+node.attributes.href+'" mce_src="'+node.attributes.href+'"></iframe>'  
	                 });  
	         }  
	         tab.setActiveTab(n);  
	      }  
	 }
	   
	 //----------------------------------使用ajax建立TabPannel------------------------------------------- 
	 Ext.Ajax.request({   
	     url:'servlet/JosnDataServlet',  
	     success: function(resp,opts) {   
             var respText=Ext.util.JSON.decode(resp.responseText);  
             for(var i=0;i<respText.length;i++){   
                 var id = respText[i].id;             //像sevlet中传入数据id////////////////////////////////// 
                 var tree=new Ext.tree.TreePanel({  
                 			 title:respText[i].text,
                 			 autoScroll:true,
                 			 iconCls:respText[i].iconCls,
                             rootVisible:false,  
                             border:false,  
                             root:new Tree.AsyncTreeNode({id:'0',disable:false}),    //根据此树根id即树根node值可以找到子系统对应功能模块 
                             loader:new Ext.tree.TreeLoader({dataUrl :'servlet/TreeDataServlet?id='+id}) //传入系统ID 通过此处id可以查找到当前循环到了哪个子系统
                               
                 })
	             Ext.getCmp('TreeTitle').add(tree);  
	             Ext.getCmp('TreeTitle').doLayout();  
	             tree.on('click',treeClick); 
	           }
	             		               
	     },   
	     failure: function(resp,opts) {   
	             var respText = Ext.util.JSON.decode(resp.responseText);   
	             Ext.Msg.alert('错误', respText.error);   
	    }
	    
	       
	 })  
}); //--------------------------------

   var tab = new Ext.TabPanel({ 
   			  id: 'props-panel', 
	          xtype:'tabpanel',  
	          deferredRender:false,  
	          region:'center',  
	          activeTab:0,  
	          enableTabScroll:true, 
	          autoScroll:true,
  			  titleCollapse:true,
	          items : [ {
	          	autoScroll:true,
	          	titleCollapse:true,
				title : '个人主页',
				closable : 'true',
				height: 1000,
				html : '<iframe scrolling="auto" frameborder="0" width="100%" height="500%" src="NewNotice!getUserNewNotice.action"></iframe>'
			} ] 
	       
  });  
  //-------------------------------修改个人信息！！！-------------------------------------------------------	  
     function addTab(t,src){
     	var n=tab.add(
	     	{
	     	        autoScroll:true, 
					title : t,
					closable : 'true',
					html : '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="'+src+'"></iframe>'
			}
     		);
     	tab.setActiveTab(n);
     }