<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>





<script>
    $(function () {


        //创建柱状图

        //DOM------> Jquery  $(DOM)
        //jquery------->DOM  jquery对象[0]
        var myChart = echarts.init($("#aaaa")[0]);

        //配置echars
        // 指定图表的配置项和数据
        $.post("${pageContext.request.contextPath}/user/selectCount",function(data){
            var dt=eval(data);
            var option = {
                title: {
                    text: '统计用户注册数'
                },
                tooltip: {},
                legend: {
                    data:['用户数量']
                },
                xAxis: {
                    data: dt.time
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: dt.counts
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        },"JSON");

    });
</script>
<div id="aaaa" style="width: 600px;height:400px;"></div>


