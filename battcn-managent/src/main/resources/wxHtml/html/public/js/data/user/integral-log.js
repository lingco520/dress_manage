
/** 获取倒计时参数  **/
var clock = '';
var nums = 60;
var btn;

/**  默认加载  **/
$(function () {
    var  process={
        init:function(){
            this.public();
        },
        public:function () {
            $('.weui-btn').click(function(){
				var num=$('.integral-title span:eq(0)').text();
				var text=$('#text').val();
				num=parseInt(num);
				if(text==''){
				 $.alert('输入内容不能为空');
				 return false;	
			    }
				else if(text<=0||text>num){
					$.alert('当前输入金额大于0或小于总金额');
				    return false;	
			    }
				else{
					window.location.href="index.html";
					}
		   })
        }
    };

    window.onload = function(){
        process.init();
    }


})


