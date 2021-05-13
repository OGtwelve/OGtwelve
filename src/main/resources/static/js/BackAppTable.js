var providerObj;


//供应商管理页面上点击删除按钮弹出删除框(providerlist.jsp)
function deleteProvider(obj){
    $.ajax({
        type:"GET",
        url:path+"/jsp/provider.do",
        data:{method:"delprovider",proid:obj.attr("proid")},
        dataType:"json",
        success:function(data){
            if(data.delResult == "true"){//删除成功：移除删除行
                cancleBtn();
                obj.parents("tr").remove();
            }else if(data.delResult == "false"){//删除失败
                //alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
                changeDLGContent("对不起，删除供应商【"+obj.attr("proname")+"】失败");
            }else if(data.delResult == "notexist"){
                //alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
                changeDLGContent("对不起，供应商【"+obj.attr("proname")+"】不存在");
            }else{
                //alert("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
                changeDLGContent("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
            }
        },
        error:function(data){
            //alert("对不起，删除失败");
            changeDLGContent("对不起，删除失败");
        }
    });
}

function openYesOrNoDLG(){
    $('.zhezhao').css('display', 'block');
    $('#removeProv').fadeIn();
}

function cancleBtn(){
    $('.zhezhao').css('display', 'none');
    $('#removeProv').fadeOut();
}
function changeDLGContent(contentStr){
    var p = $(".removeMain").find("p");
    p.html(contentStr);
}



// $(function(){
//     var pageNum = 1;
//     var u_nameid = $('#u_nameid').val();
//     if (u_nameid==1){
//         initPro()
//     }else if(u_nameid==2){
//         initPro3();
//     }else {
//         initPro2();
//     }

    var pageNum = 1;
    initPro();
    function initPro() {
        $("#proviAppTable").html("");
        $("#div").html("");
        $("#proviAppTable").append(" <tr class=\"firstTr\">\n" +
            "              <th width=\"10%\">Appid</th>\n" +
            "              <th width=\"20%\">App昵称</th>\n" +
            "              <th width=\"10%\">APk昵称</th>\n" +
            "              <th width=\"10%\">上架时间</th>\n" +
            "              <th width=\"10%\">开发者ID</th>\n" +
            "              <th width=\"10%\">状态</th>\n" +
            "              <th width=\"10%\">创建时间</th>\n" +
            "              <th width=\"30%\">操作</th>\n" +
            "          </tr>\n")
        $.post("App/getPage2",
            {"pageNum": pageNum},
            getPage,
            "JSON"
        );

        function getPage(data) {
            $(data.list).each(function () {
                console.log(this)
                $("#proviAppTable").append("<tr>\n" +
                    "\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t<span>" + this.id + "</span>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t<span>" + this.softwareName + "</span>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t<span>" + this.apkname + "</span>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t<span>" + this.onSaleDate + "</span>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t<span>" + this.devId + "</span>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t<span>\n" +
                    "\t\t\t\t\t\t\t"+(this.status == 4?"待审核":"")+"" +
                    "\t\t\t\t\t\t\t"+(this.status == 5?"审核通过":"")+"" +
                    "\t\t\t\t\t\t\t"+(this.status == 6?"审核未通过":"")+"" +
                    "\t\t\t\t\t\t\t"+(this.status == 7?"已上架":"")+"" +
                    "\t\t\t\t\t\t\t"+(this.status == 8?"已下架":"")+"" +
                    "\t\t\t\t\t</span>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t<td>\n" +
                    "\t\t\t\t\t<span>" + this.creationDate + "</span>\n" +
                    "\t\t\t\t\t</td>\n" +
                    "                <td>\n" +
                    "                    <a href=\"App/AppView?id="+this.id+"\">查看</a>\n" +
                    "                    <a href=\"App/AppGetOne2?id="+this.id+"\">修改</a>\n" +
                    "                </td>\n" +
                    "\t\t\t\t</tr>")
                //REST风格：之前传递参数通过？后面携带参数传值
                //Representational State Transfer，表述性状态转移s
                //      直接通过/传递参数
                //      /user/del？id=12   =>     /user/del/12
                //      虽然REST风格，传递及页面信息比较清晰，但是会有中文乱码的问题
                //      一般开发中，传统风格和REST风格混搭
                $(".delApp").click(function () {
                    var id = $(this).attr("value");
                    var versionId = $(this).attr("vId");
                    $.post("App/del/" + id+"/"+versionId, AppDel, "text");

                    function AppDel(data) {
                        if (data == "true") {
                            alert("删除成功");
                            pageNum = 1;
                            initPro();
                        } else {
                            alert("删除失败")
                        }
                    }
                })
            })

            $("#div").append("当前页" + data.pageNum + "/" + data.pages);
            if (data.pageNum > 1) {
                $("#div").append("<span id='sy'>首页</span>\n" +
                    "            <span id='syy'>上一页</span>"
                )
            }
            if (data.pageNum < data.pages) {
                $("#div").append("<span id='xyy'>下一页</span>\n" +
                    "            <span id='wy'>尾页</span>")
            }


            //首页
            $("#sy").click(function () {
                pageNum = 1;
                initPro();
            });
            //上一页
            $("#syy").click(function () {
                pageNum = data.pageNum - 1;
                initPro();
            });

            $("#xyy").click(function () {
                pageNum = data.pageNum + 1;
                initPro();
            });

            $("#wy").click(function () {
                pageNum = data.pages;
                initPro();
            });
        }
    }


