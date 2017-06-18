<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>



    <script src="${pageContext.request.contextPath}/back/easyui/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/back/easyui/js/echarts.js"></script>


    <script>

        $(function () {


            //创建图表
            var myChart = echarts.init($("#aaaa")[0]);
            $.post("${pageContext.request.contextPath}/echars/test",function(data){
                var option = {
                    title: {
                        text: '统计用户注册数'
                    },
                    tooltip: {},
                    legend: {
                        data:['用户数量']
                    },
                    xAxis: {
                        data: data.dates,
                    },
                    yAxis: {},
                    series: [{
                        name: '用户数',
                        type: 'bar',
                        data: data.counts,
                    }]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);

            },"JSON");



        });


    </script>


<body>




    <div id="aaaa" style="width: 600px;height:400px;"></div>


</body>

