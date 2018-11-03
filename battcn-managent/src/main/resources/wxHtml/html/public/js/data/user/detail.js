
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
            var phone=$("#phone").val();
			var code=$("#code").val();
			$("#doSent").click(function(){
			   var phone=$("#phone").val();
			   var code=$("#code").val();
			   if(!isPhone(phone)) return;
               if(!isYzm(code)) return;
			   window.location.href="index.html"
			})
			
        }
    };

    window.onload = function(){
        process.init();
    }


})



/**
 * 验证码循环
 * @param value
 * @returns {*}
 */

function sendCode(thisBtn)
{
    var phone=$("#phone").val();
    if(!isPhone(phone)) return;
    //获取倒计时
    btn = thisBtn;
    if(!btn.disabled){
        btn.disabled = true; //将按钮置为不可点击
        clock = setInterval(doLoop, 1000); //一秒执行一次
        $('.layerError').html('');
        return clock;
    }

}
function doLoop()
{
    nums--;
    if(nums > 0){
        $(".sentTime").hide();
        $(".getTime").show();
        $(".getTime").html("重新发送"+nums);
    }else{
        clearInterval(clock); //清除js定时器
        btn.disabled = false;
        $(".getTime").hide();
        $(".sentTime").show();
        $(".sentTime").html("重新发送");
        nums = 60; //重置时间
    }
}

/**
 * 手机号码校验
 * @param value
 * @returns {*}
 */

function isPhone(value) {
    var phone = value;
    if (phone == "") {
        $.alert('手机号码不能为空');
        return false;
    }
    var patterns = /^1[3,5,8,7,4]\d{9}$/;
    if (!patterns.test(phone)) {
        $.alert('手机号码错误');
        return false;
    }
    return true;

}

/**
 * 4位验证码校验
 * @param value
 * @returns {*}
 */
function isYzm(value) {
    var code = value;
    if (code == "") {
         $.alert('验证码不能为空');
        return false;
    }
    var reg = /^[0-9A-Za-z]{4}$/;
    if (!reg.test(code)) {
        $.alert('验证码错误');
        return false;
    } else {
        return true;
    }
}

