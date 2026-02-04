import _easycom_rice_icon from '@/uni_modules/rice-ui/components/rice-icon/rice-icon.uvue'
import { addUnit, getPxNum, hasStrValue } from "../../libs/utils"
	import { useNamespace } from "../../libs/use"
	import { isDark } from "../../libs/store"
	import { NavbarProps } from "./type.uts"

	
const __sfc__ = defineComponent({
  __name: 'rice-navbar',

		name: 'rice-navbar'
	,
  props: {
    title: { type: String, required: false },
    titleSize: { type: [String, Number], required: false },
    titleColor: { type: String, required: false },
    titleWidth: { type: [String, Number], required: false },
    fixed: { type: Boolean, required: false, default: true },
    placeholder: { type: Boolean, required: false, default: true },
    border: { type: Boolean, required: false, default: false },
    leftArrow: { type: Boolean, required: false, default: true },
    leftIcon: { type: String, required: false, default: 'arrow-left' },
    leftIconSize: { type: [String, Number], required: false, default: '20px' },
    leftIconColor: { type: String, required: false },
    leftText: { type: String, required: false },
    leftTextColor: { type: String, required: false },
    rightText: { type: String, required: false },
    rightTextColor: { type: String, required: false },
    zIndex: { type: Number, required: false },
    bgColor: { type: String, required: false },
    safeAreaInsetTop: { type: Boolean, required: false, default: true },
    height: { type: [String, Number], required: false, default: '44px' },
    autoBack: { type: Boolean, required: false, default: true },
    customStyle: { type: UTSJSONObject, required: false, default: () : UTSJSONObject => ({}) }
  },
  emits: ["clickLeft", "clickRight"],
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	/**
 * @description Navbar
 * @property {String} title 导航栏标题
 * @property {String|Number} titleSize 标题文字的大小,默认16px
	 @property {String|Number} titleColor 标题文字的颜色
 * @property {String|Number} titleWidth 标题栏最大宽度，超出会显示省略号,默认70%
 * @property {Boolean} fixed 是否固定在顶部，默认true
 * @property {Boolean} placeholder 固定在顶部时，是否生成一个等高的元素防止塌陷，默认true
 * @property {Boolean} border 导航栏底部是否显示下边框，默认true
 * @property {Boolean} leftArrow 是否显示返回箭头，默认true
 * @property {String} leftIcon 左侧返回图标的名称，默认 arrow-left
 * @property {String} leftIconSize 左侧返回图标的大小
 * @property {String} leftIconColor 左侧返回图标的颜色
 * @property {String} leftText 左侧文案
 * @property {String} leftTextColor 左侧文案颜色
 * @property {String} rightText 右侧文案
 * @property {String} rightTextColor 右侧文案颜色
 * @property {Number} zIndex 层级，默认999
 * @property {String} bgColor 背景色，支持渐变色
 * @property {Boolean} safeAreaInsetTop 是否开启顶部安全区适配,默认true
 * @property {String|Number} height 导航栏高度，不包含状态栏，safeAreaInsetTop为true时内部会自动加上状态栏的高度，默认44px
 * @property {Boolean} autoBack 点击左侧箭头区域，是否自动返回上一页，默认true
 * @property {Object} customStyle 自定义样式
 */
	
	const slot = useSlots()
	function emit(event: string, ...do_not_transform_spread: Array<any | null>) {
__ins.emit(event, ...do_not_transform_spread)
}
	const ns = useNamespace('navbar')

	const props = __props

	const hasLeft = computed(() => slot['left'] != null || props.leftArrow || hasStrValue(props.leftText))
	const hasRight = computed(() => slot['right'] != null || hasStrValue(props.rightText))
	const statusBarHeight = ref(0)

	const clickLeft = (e : UniPointerEvent) => {
		if (slot['left'] != null) return
		e.stopPropagation()
		if (props.autoBack) uni.navigateBack()
		emit('clickLeft')
	}

	const clickRight = (e : UniPointerEvent) => {
		if (slot['right'] != null) return
		e.stopPropagation()
		emit('clickRight')
	}

	const arrowColor = computed<string>(() => {
		if (hasStrValue(props.leftIconColor)) return props.leftIconColor!
		return !isDark.value ? '#323233' : '#f5f5f5'
	})

	const navbarHeight = computed(() => {
		let height = getPxNum(props.height)
		if (props.safeAreaInsetTop) height += statusBarHeight.value
		return height + 'px'
	})

	const centerStyle = computed(() => {
		const css = new Map<string, string>()
		if (props.titleWidth != null) css.set('width', addUnit(props.titleWidth!))
		return css
	})

	const navbarStyle = computed(() => {
		const css = new Map<string, string | number>()
		if (hasStrValue(props.bgColor)) css.set('background', props.bgColor!)
		if (props.fixed && props.zIndex != null) css.set('z-index', props.zIndex!)
		css.set('height', addUnit(props.height!))
		return css
	})

	const leftTextStyle = computed(() => {
		const css = new Map<string, string>()
		if (hasStrValue(props.leftTextColor)) css.set('color', props.leftTextColor!)
		return css
	})

	const rightTextStyle = computed(() => {
		const css = new Map<string, string>()
		if (hasStrValue(props.rightTextColor)) css.set('color', props.rightTextColor!)
		return css
	})

	const titleTextStyle = computed(() => {
		const css = new Map<string, string>()
		if (hasStrValue(props.titleColor)) css.set('color', props.titleColor!)
		if (props.titleSize != null) css.set('font-size', addUnit(props.titleSize!))
		return css
	})

	const navbarClass = computed(() => {
		return [
			ns.b(""),
			ns.theme(),
			ns.is('fixed', props.fixed),
			ns.is('safearea-top', props.safeAreaInsetTop),
			ns.is('border', props.border),
		]
	})








	onMounted(() => {
		const windowInfo = uni.getWindowInfo()





		statusBarHeight.value = windowInfo.statusBarHeight
	})

return (): any | null => {

const _component_rice_icon = resolveEasyComponent("rice-icon",_easycom_rice_icon)

  return _cE(Fragment, null, [
    isTrue(_ctx.fixed&&_ctx.placeholder)
      ? _cE("view", _uM({
          key: 0,
          class: "rice-navbar--placeholder",
          style: _nS(_uM({height:unref(navbarHeight)}))
        }), null, 4 /* STYLE */)
      : _cC("v-if", true),
    _cE("view", _uM({
      class: _nC(unref(navbarClass)),
      style: _nS(unref(navbarStyle))
    }), [
      isTrue(unref(hasLeft))
        ? _cE("view", _uM({
            key: 0,
            class: _nC(["rice-navbar__aside rice-navbar__left", _uM({'rice-navbar__aside--safearea-top':_ctx.safeAreaInsetTop})]),
            onClick: withModifiers(clickLeft, ["stop"])
          }), [
            renderSlot(_ctx.$slots, "left", {}, (): any[] => [
              isTrue(_ctx.leftArrow)
                ? _cV(_component_rice_icon, _uM({
                    key: 0,
                    name: _ctx.leftIcon,
                    size: _ctx.leftIconSize,
                    color: unref(arrowColor)
                  }), null, 8 /* PROPS */, ["name", "size", "color"])
                : _cC("v-if", true),
              isTrue(unref(hasStrValue)(_ctx.leftText))
                ? _cE("text", _uM({
                    key: 1,
                    style: _nS(unref(leftTextStyle)),
                    class: "rice-navbar__aside__text"
                  }), _tD(_ctx.leftText), 5 /* TEXT, STYLE */)
                : _cC("v-if", true)
            ])
          ], 2 /* CLASS */)
        : _cC("v-if", true),
      _cE("view", _uM({
        class: _nC(["rice-navbar__center", _uM({'rice-navbar__center--has-right':unref(hasRight)&&_ctx.safeAreaInsetTop})]),
        style: _nS(unref(centerStyle))
      }), [
        renderSlot(_ctx.$slots, "title", {}, (): any[] => [
          _cE("text", _uM({
            class: "rice-navbar__title",
            style: _nS(unref(titleTextStyle))
          }), _tD(_ctx.title), 5 /* TEXT, STYLE */)
        ])
      ], 6 /* CLASS, STYLE */),
      isTrue(unref(hasRight))
        ? _cE("view", _uM({
            key: 1,
            class: _nC(["rice-navbar__aside rice-navbar__right", _uM({'rice-navbar__aside--safearea-top':_ctx.safeAreaInsetTop})]),
            onClick: withModifiers(clickRight, ["stop"])
          }), [
            renderSlot(_ctx.$slots, "right", {}, (): any[] => [
              isTrue(unref(hasStrValue)(_ctx.rightText))
                ? _cE("text", _uM({
                    key: 0,
                    class: "rice-navbar__aside__text",
                    style: _nS(unref(rightTextStyle))
                  }), _tD(_ctx.rightText), 5 /* TEXT, STYLE */)
                : _cC("v-if", true)
            ])
          ], 2 /* CLASS */)
        : _cC("v-if", true)
    ], 6 /* CLASS, STYLE */)
  ], 64 /* STABLE_FRAGMENT */)
}
}

})
export default __sfc__
export type RiceNavbarComponentPublicInstance = InstanceType<typeof __sfc__>;
const GenUniModulesRiceUiComponentsRiceNavbarRiceNavbarStyles = [_uM([["rice-navbar", _pS(_uM([["position", "relative"], ["flexDirection", "row"], ["alignItems", "center"], ["justifyContent", "center"], ["backgroundColor", "var(--rice-navbar-background)"], ["height", 44], ["boxSizing", "content-box"], ["width", "100%"]]))], ["rice-navbar--fixed", _pS(_uM([["position", "fixed"], ["left", 0], ["right", 0], ["top", 0], ["width", "100%"], ["zIndex", 998]]))], ["rice-navbar--placeholder", _pS(_uM([["width", "100%"]]))], ["rice-navbar--border", _pS(_uM([["borderBottomWidth", 1], ["borderBottomStyle", "solid"], ["borderBottomColor", "var(--rice-border-color)"]]))], ["rice-navbar--safearea-top", _pS(_uM([["paddingTop", CSS_VAR_STATUS_BAR_HEIGHT]]))], ["rice-navbar__aside", _pS(_uM([["position", "absolute"], ["bottom", 0], ["top", 0], ["paddingTop", 0], ["paddingRight", 10], ["paddingBottom", 0], ["paddingLeft", 10], ["flexDirection", "row"], ["alignItems", "center"]]))], ["rice-navbar__aside--safearea-top", _pS(_uM([["top", CSS_VAR_STATUS_BAR_HEIGHT]]))], ["rice-navbar__aside__text", _pS(_uM([["fontSize", "var(--rice-font-size-sm)"], ["color", "var(--rice-text-color)"]]))], ["rice-navbar__left", _pS(_uM([["left", 0]]))], ["rice-navbar__right", _pS(_uM([["right", 0]]))], ["rice-navbar__center", _pS(_uM([["alignItems", "center"], ["paddingTop", 0], ["paddingRight", 10], ["paddingBottom", 0], ["paddingLeft", 10], ["boxSizing", "border-box"], ["width", "70%"]]))], ["rice-navbar__title", _pS(_uM([["width", "100%"], ["fontSize", "var(--rice-font-size-md)"], ["color", "var(--rice-text-color)"], ["fontWeight", "bold"], ["textAlign", "center"], ["whiteSpace", "nowrap"], ["textOverflow", "ellipsis"]]))]])]
