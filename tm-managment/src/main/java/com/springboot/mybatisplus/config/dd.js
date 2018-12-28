(function(){
    var doc = getCurrentDocument();
    var dValue = doc.getItemValueAsString("项目所属路径");   //获取到相应的部门名称
    var  dparry=splitText(dValue,"/");
    var path="";
    for(var i=1;i<dparry.length;i++){
       if(i!=dparry.length-1){
           path+=dparry[i]+"/";
       }else {
           path+=dparry[i];
       }

    }
    return path;
})();