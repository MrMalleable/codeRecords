/**
 * Created by MrBread on 2017/8/9.
 */
/*
* 传入三个参数：
* startpage:一开始显示的起始页
* pagesize:每页显示的记录数
* pagenum:每一个导航栏可以显示的页面链接数 如1,2,3或者1,2,3,4,5
* */
function jumpPage(startpage,pagesize,pagenum) {
    //获取id="databody"的tbody的元素对象
    var table=document.getElementById("databody");
    //获取记录的总数
    var recordsnum=table.rows.length;

    //根据recordsnum和pagesize的值来确定总共显示多少页
    var totalpage;
    if(recordsnum/pagesize > parseInt(recordsnum/pagesize)){
        totalpage=parseInt(recordsnum/pagesize)+1;
    }else{
        totalpage=parseInt(recordsnum/pagesize);
    }
    console.log(totalpage)

    //设置在当前界面显示哪几条记录
    var startrow=(startpage-1)*pagesize+1; //开始显示的记录行
    var endrow=startpage*pagesize;
    //判断endrow的有效性，因为如果是最后一页的话endrow不一定能取到底
    endrow=(endrow>recordsnum)?recordsnum:endrow;
    //设置这几条记录的属性为table-row
    for(i=0;i<recordsnum;i++){
        if(i+1>=startrow&&i+1<=endrow){
            table.rows[i].style.display="table-row";
        }else{
            table.rows[i].style.display="none";
        }
    }

    //接下来就是要设置导航栏的链接
    // <li class="disabled"><a href="#">首页</a></li>
    //     <li class="disabled">
    //     <a href="#" aria-label="Previous">
    //     <span aria-hidden="true">&laquo;</span>
    // </a>
    // </li>
    // <li class="active"><a href="#">1</a></li>
    //     <li><a href="#">2</a></li>
    //     <li><a href="#">3</a></li>
    //     <li>
    //     <a href="#" aria-label="Next">
    //     <span aria-hidden="true">&raquo;</span>
    // </a>
    // </li>
    // <li><a href="#">末页</a></li>
    var ul=document.getElementById("dividepage");
    //设置首页链接
    var link="<li><a href='#' onclick='jumpPage(1,"+pagesize+","+pagenum+")'>首页</a></li>";
    //设置上一页链接
    link+="<li id='previouspage'><a href='#' onclick='jumpPage("+(startpage-1)+","+pagesize+","+pagenum+")'><span aria-hidden='true'>&laquo;</span></a></li>";
    //根据pagenum的值设置中间数字的页面链接
    for(i=0;i<pagenum;i++){
        if((startpage+i)<=totalpage) {
            if (i == 0) { //设置当前浏览的页面的li标签的class属性为active
                link += "<li class='active'><a href='#' onclick='jumpPage(" + (startpage + i) + "," + pagesize + "," + pagenum + ")'>" + (startpage + i) + "</a></li>";
            } else {
                link += "<li><a href='#' onclick='jumpPage(" + (startpage + i) + "," + pagesize + "," + pagenum + ")'>" + (startpage + i) + "</a></li>";
            }
        }
    }
    //设置下一页链接
    link+="<li id='nextpage'><a href='#' onclick='jumpPage("+(startpage+1)+","+pagesize+","+pagenum+")'><span aria-hidden='true'>&raquo;</span></a></li>";
    //设置尾页链接
    link+="<li><a href='#' onclick='jumpPage("+totalpage+","+pagesize+","+pagenum+")'>尾页</a></li>";
    ul.innerHTML=link;
    if(startpage==1){
        //如果该页为首页则设置上一页的链接失效
        document.getElementById("previouspage").setAttribute("class","disabled");
    }
    if(startpage==totalpage){
        //如果该页为尾页则设置下一页的链接失效
        document.getElementById("nextpage").setAttribute("class","disabled");
    }

}