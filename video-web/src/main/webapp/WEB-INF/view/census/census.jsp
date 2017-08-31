<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>视频平均播放次数统计</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<a class="navbar-brand"
						href="${pageContext.request.contextPath }/admin/search.action">视频管理系统</a>
				</div>
				<div class="navbar-header">
					<a class="navbar-brand"
						href="${pageContext.request.contextPath }/admin/search.action">视频管理</a>
				</div>
				<div class="navbar-header">
					<a class="navbar-brand"
						href="${pageContext.request.contextPath }/admin/searchspeaker.action">主讲人管理</a>
				</div>
				<div class="navbar-header">
					<a class="navbar-brand"
						href="${pageContext.request.contextPath }/admin/searchcourse.action">课程管理</a>
				</div>
				<div class="navbar-header">
					<a class="navbar-brand"
						href="${pageContext.request.contextPath }/census.action">统计分析</a>
				</div>
				<div class="navbar-header" style="float: right;">
					<a class="navbar-brand"
						href="${pageContext.request.contextPath }/houtai/index.jsp">${admin.loginName}<span
						class="glyphicon glyphicon-log-out"></span></a>
				</div>
			</div>
		</div>
	</nav>
	<div class="container">
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="height: 400px"></div>
	<!-- ECharts单文件引入 -->
	<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
	<script type="text/javascript">
		// 路径配置
		require.config({
			paths : {
				echarts : 'http://echarts.baidu.com/build/dist'
			}
		});

		// 使用
		require([ 'echarts', 'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
		], function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('main'));
			var name = '${coursename}';
			var times = '${avgtimes}';
			var coursename = name.split(",");
			var avgtimes = times.split(",");

			var option = {
				title : {
					x : 'center',
					text : '视频平均播放次数统计',
					link : 'http://echarts.baidu.com/doc/example.html'
				},
				tooltip : {
					trigger : 'item'
				},
				toolbox : {
					show : true,
					feature : {
						dataView : {
							show : true,
							readOnly : false
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				grid : {
					borderWidth : 0,
					y : 80,
					y2 : 60
				},
				xAxis : [ {
					type : 'category',
					show : false,
					data : coursename
				} ],
				yAxis : [ {
					type : 'value',
					show : false
				} ],
				series : [ {
					name : '视频平均播放次数统计',
					type : 'bar',
					itemStyle : {
						normal : {
							color : function(params) {
								// build a color map as your need.
								var colorList = [ '#C1232B', '#B5C334',
										'#FCCE10', '#E87C25', '#27727B',
										'#FE8463', '#9BCA63', '#FAD860',
										'#F3A43B', '#60C0DD', '#D7504B',
										'#C6E579', '#F4E001', '#F0805A',
										'#26C0C0' ];
								return colorList[params.dataIndex]
							},
							label : {
								show : true,
								position : 'top',
								formatter : '{b}\n{c}'
							}
						}
					},
					data : avgtimes,
					markPoint : {
						tooltip : {
							trigger : 'item',
							backgroundColor : 'rgba(0,0,0,0)',
							formatter : function(params) {
								return '<img src="'
										+ params.data.symbol.replace(
												'image://', '') + '"/>';
							}
						},
						data : [ {
							xAxis : 0,
							y : 350,
							name : 'Line',
							symbolSize : 20,
							symbol : 'image://../asset/ico/折线图.png'
						}, {
							xAxis : 1,
							y : 350,
							name : 'Bar',
							symbolSize : 20,
							symbol : 'image://../asset/ico/柱状图.png'
						}, {
							xAxis : 2,
							y : 350,
							name : 'Scatter',
							symbolSize : 20,
							symbol : 'image://../asset/ico/散点图.png'
						}, {
							xAxis : 3,
							y : 350,
							name : 'K',
							symbolSize : 20,
							symbol : 'image://../asset/ico/K线图.png'
						}, {
							xAxis : 4,
							y : 350,
							name : 'Pie',
							symbolSize : 20,
							symbol : 'image://../asset/ico/饼状图.png'
						}, {
							xAxis : 5,
							y : 350,
							name : 'Radar',
							symbolSize : 20,
							symbol : 'image://../asset/ico/雷达图.png'
						}, ]
					}
				} ]
			};

			// 为echarts对象加载数据 
			myChart.setOption(option);
		});
	</script>
	</div>
</body>