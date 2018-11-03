
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
            $('html').on('click','.user-address .sel',function(){
				$(this).addClass('on').siblings().removeClass('on');
		   })
        }
    };

    window.onload = function(){
        process.init();
    }


})


