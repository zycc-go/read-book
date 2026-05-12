
const __sfc__ = defineComponent({
  __name: 'uni-nav-bar',

  	// inheritAttrs: false,
  	externalClasses: ['left-class','mid-class','right-class']
  ,
  props: {
    /**
     * @description 是否隐藏默认的返回箭头。为 true 时需要通过 left 插槽自定义返回按钮
     * @default false
     */
    hideDefaultBack: { type: Boolean, default: false },
    /**
     * @description 导航栏中间显示的标题文字，若使用 mid 插槽则该属性无效
     * @default ""
     */
    title: { type: String, default: "" },
    // navigationBarTextStyle: { type: "#000000" | "#ffffff" | "#000" | "#fff" | "black" | "white" | "", default: "" },
    /**
     * @description 导航栏前景色（文字和返回箭头颜色）。非小程序端未传入时会自动读取 pageStyle 的 navigationBarTextStyle
     * @default ""
     */
    navigationBarTextStyle: { type: String as PropType<"white" | "black" | "">, default: "" },
    /**
     * @description 左侧区域的自定义样式类
     * @default ""
     */
    leftClass: { type: String, default: "" },
    /**
     * @description 中间区域的自定义样式类
     * @default ""
     */
    midClass: { type: String, default: "" },
    /**
     * @description 右侧区域的自定义样式类
     * @default ""
     */
    rightClass: { type: String, default: "" }
    // stat: { type: Boolean, default: false }
  },
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

  /**
   * 自定义导航栏
   * @description 自定义导航栏组件
   * @uniPlatform {
   *   "app": {
   *     "android": {
   *       "uniVer": "x",
   *       "unixVer": "5.07",
   *       "unixvVer": "x"
   *     },
   *     "ios": {
   *       "uniVer": "x",
   *       "unixVer": "5.07",
   *       "unixvVer": "x"
   *     },
   *     "harmony": {
   *       "uniVer": "x",
   *       "unixVer": "5.07",
   *       "unixvVer": "5.08"
   *     }
   *   },
   *   "mp": {
   *     "weixin": {
   *       "uniVer": "x",
   *       "unixVer": "5.07"
   *     }
   *   },
   *   "web": {
   *     "uniVer": "x",
   *     "unixVer": "5.07"
   *   }
   * }
   */
  
  const props = __props
  const slots = useSlots();


// 获取pageStyle在web和app上都没有兼容theme.json的场景，这段代码注释掉。需要先修改底层bug。本组件使用了其他方案
/*  const currentPage = getCurrentInstance()?.proxy?.$page
	console.log("props.navigationBarTextStyle:",props.navigationBarTextStyle);
	console.log("navigationBarTextStyle：",currentPage?.getPageStyle()["navigationBarTextStyle"]);
	console.log("backgroundColorContent：",currentPage?.getPageStyle()["backgroundColorContent"]);
  const foreColor = (props.navigationBarTextStyle=="") ? currentPage?.getPageStyle()["navigationBarTextStyle"] : props.navigationBarTextStyle; //如果外部没有传入前景色，从pageStyle获取
	console.log("foreColor:",foreColor); */





	/* const foreColor = computed(() : string => {
		return props.navigationBarTextStyle;
	}) */

  // let statusBarHeight = ref(0)
  onMounted(() => {





    /* if (props.stat && props.title != '') {
      uni.report({
        name: 'title',
        options: props.title
      })
    } */
  })

  const back = () => {
    uni.navigateBack({});
  }

return (): any | null => {

  return _cE("view", _uM({
    style: _nS(_uM({"flex-direction":"row","padding-top":"var(--status-bar-height)","box-sizing":"content-box","align-items":"center","position":"relative"}))
  }), [
    _cE("view", _uM({
      style: _nS(_uM({"height":"44px","align-items":"center","justify-content":"center"})),
      class: _nC(["uni-left-class-buildin", _ctx.leftClass])
    }), [
      isTrue(!_ctx.hideDefaultBack && unref(slots)['left']==null)
        ? _cE("view", _uM({
            key: 0,
            style: _nS(_uM({"width":"44px","height":"44px","justify-content":"center","align-items":"center"})),
            onClick: back
          }), [
            _cE("view", _uM({
              style: _nS([_uM({"width":"12px","height":"12px","transform":"rotate(45deg)","border-left":"2px solid","border-bottom":"2px solid"}), _uM({borderLeftColor:props.navigationBarTextStyle,borderBottomColor:props.navigationBarTextStyle})])
            }), null, 4 /* STYLE */)
          ], 4 /* STYLE */)
        : renderSlot(_ctx.$slots, "left", _uM({ key: 1 }))
    ], 6 /* CLASS, STYLE */),
    _cE("view", _uM({
      style: _nS(_uM({"position":"absolute","height":"44px","flex-direction":"row","align-items":"center"})),
      class: _nC(["uni-mid-class-buildin", _ctx.midClass]),
      flatten: ""
    }), [
      unref(slots)['mid']==null
        ? _cE("text", _uM({
            key: 0,
            style: _nS(_uM({ color: props.navigationBarTextStyle })),
            flatten: ""
          }), _tD(_ctx.title), 5 /* TEXT, STYLE */)
        : renderSlot(_ctx.$slots, "mid", _uM({ key: 1 }))
    ], 6 /* CLASS, STYLE */),
    _cE("view", _uM({
      style: _nS(_uM({"position":"absolute","height":"44px","flex-direction":"row","align-items":"center","right":"0"})),
      class: _nC(["uni-right-class-buildin", _ctx.rightClass]),
      flatten: ""
    }), [
      renderSlot(_ctx.$slots, "right")
    ], 6 /* CLASS, STYLE */)
  ], 4 /* STYLE */)
}
}

})
export default __sfc__
export type UniNavBarComponentPublicInstance = InstanceType<typeof __sfc__>;
const GenUniModulesUniNavBarXComponentsUniNavBarUniNavBarStyles = [_uM([["uni-left-class-buildin", _pS(_uM([["width", 44], ["marginLeft", 6]]))], ["uni-mid-class-buildin", _pS(_uM([["justifyContent", "center"], ["left", 52], ["right", 52]]))], ["uni-right-class-buildin", _pS(_uM([["width", 44], ["marginRight", 6]]))]])]
