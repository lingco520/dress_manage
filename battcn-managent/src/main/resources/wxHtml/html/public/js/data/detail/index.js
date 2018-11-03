
/**  默认加载  **/
$(function () {
    var  process={
        init:function(){
            this.swiper();
            this.public();
        },
        swiper:function () {
            /*  轮播效果加载   */
            var t=$(".swiper-wrapper img").length;
            if(t<2){
            }else {
                //首页加载
                $(".swiper-container").swiper({
                    loop: true,
                    autoplayDisableOnInteraction: false,
                    autoplay: 3000
                });
            }
        },
        public:function () {
            /** 点击勾选是否同意协议 **/
            $(".isure").click(function(){
                if($(this).find('.left').hasClass("on")){
                    $(this).find('.left').removeClass("on");
                }
                else{
                    $(this).find('.left').addClass("on");
                }
            });
            /** 点击勾选是否同意协议 **/
            $(".footer .weui-btn").click(function(){
                var isure=$('.isure').find('.left').hasClass("on");
                if(isure){
                   window.location.href='order-start.html';
                }
                else{
                    $.modal({
                        title: "请先同意购物条款",
                        text: "您还未同意购物条款，请勾选",
                        buttons: [
                            { text: "确定"},
                        ]
                    });
                }
            });
            /** 选择套餐 **/
            $(".numContent li").click(function(){
                $(this).addClass('on').siblings().removeClass('on');
                var id=$(this).attr('data-id');
                switch (id){
                    case '1':
                        $.alert(1);
                        break;
                    case '2':
                        $.alert(2);
                        break;
                    case '3':
                        $.alert(3);
                        break;
                    case '4':
                        $.alert(4);
                        break;

                }
            });
        }
    };

    window.onload = function(){
        process.init();
    }


})
