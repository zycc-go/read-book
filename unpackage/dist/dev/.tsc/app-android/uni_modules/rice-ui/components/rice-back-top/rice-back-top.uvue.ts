import _easycom_rice_icon from '@/uni_modules/rice-ui/components/rice-icon/rice-icon.uvue'
import { useNamespace } from "../../libs/use"
	import { addUnit, hasStrValue } from "../../libs/utils"
	import { BackTopProps } from './type.uts'

	
const __sfc__ = defineComponent({
  __name: 'rice-back-top',

		name: 'rice-back-top'
	,
  props: {
    mode: { type: String, required: false, default: 'round' },
    parentId: { type: String, required: false },
    scrollTop: { type: Number, required: false },
    offset: { type: Number, required: false, default: 200 },
    right: { type: [String, Number], required: false },
    bottom: { type: [String, Number], required: false },
    duration: { type: Number, required: false, default: 300 },
    icon: { type: String, required: false, default: 'back-top' },
    iconSize: { type: [String, Number], required: false },
    text: { type: String, required: false },
    textSize: { type: [String, Number], required: false },
    textColor: { type: String, required: false },
    width: { type: [String, Number], required: false },
    height: { type: [String, Number], required: false },
    radius: { type: [String, Number], required: false },
    bgColor: { type: String, required: false },
    zoom: { type: Boolean, required: false, default: true },
    zIndex: { type: Number, required: false },
    customStyle: { type: UTSJSONObject, required: false, default: () : UTSJSONObject => ({}) }
  },
  emits: ["click"],
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	/**
	 * @description BackTop
	 * @property {Number} scrollTop 页面的滚动距离，通过onPageScroll生命周期获取，仅支持小程序
	 * @property {Number} offset 滚动条滑动多少距离时显示组件，默认400px
	 * @property {String} mode 样式类型
	 * @value round 圆形（默认值）
	 * @value half-round 半圆
	 * @property {String} parentId scroll-view 或 list 组件的 id
	 * @property {String|Number} right 距离页面右侧的距离，默认 20px
	 * @property {String|Number} bottom 距离页面底部的距离，组件内部会自动避开底部tabbar和安全区域，默认 100px
	 * @property {Number} duration 滚动到顶部所需的时间，单位ms，默认100ms
	 * @property {String} icon 按钮内部的图标，设置为空字符串就不显示图标，默认值back-top
	 * @property {String|Number} iconSize 图标的大小
	 * @property {String} textColor 图标/文字的颜色
	 * @property {String} text 按钮内部的文字,优先级低于icon，图标和文字同时只能显示一个(使用自定义插槽除外)
	 * @property {String} textSize 按钮内部文字的大小，默认13px
	 * @property {String|Number} width 宽度，默认45px
	 * @property {String|Number} height 高度，默认45px
	 * @property {String|Number} radius 圆角值，默认和width一致
	 * @property {Boolean} zoom 是否启用缩放动画
	 * @property {String} bgColor 按钮背景颜色
	 * @property {Number} zIndex z-index的值,默认998
	 * @property {Object} customStyle 自定义按钮样式
	 */
	

	const ns = useNamespace('back-top')
	function emit(event: string, ...do_not_transform_spread: Array<any | null>) {
__ins.emit(event, ...do_not_transform_spread)
}
	const props = __props


	const _scrollTop = ref(0)






	const backTopRef = shallowRef<UniElement | null>(null)


	const isShow = computed(() => _scrollTop.value >= props.offset)





	const backToTop = (e : UniPointerEvent) => {


		if (hasStrValue(props.parentId)) {
			const el = uni.getElementById(props.parentId!)
			if (el != null) {
				el.scrollTop = _scrollTop.value
				nextTick(() => {
					el.scrollTop = 0
				})
			}
		} else {
			uni.pageScrollTo({
				scrollTop: 0,
				duration: props.duration
			})
		}









		emit('click', e)

	}


	//小程序自定义组件不支持页面的 onPageScroll 生命周期，需要手动传递scrollTop
	onPageScroll((e) => {




		_scrollTop.value = e.scrollTop
	})


	const _iconSize = computed(() => {
		if (props.iconSize != null) return props.iconSize!
		return hasStrValue(props.text) ? '20px' : '24px'
	})



	const backTopStyle = computed(() => {
		const css = new Map<string, string | number>()
		if (props.zIndex != null) css.set('z-index', props.zIndex!)
		if (props.bottom != null) css.set('bottom', addUnit(props.bottom!))
		if (props.right != null) css.set('right', addUnit(props.right!))
		if (hasStrValue(props.bgColor)) {
			css.set('background', props.bgColor!)
			css.set('border-color', props.bgColor!)
		}
		if (props.height != null) css.set('height', props.height!)
		if (props.width != null) css.set('width', props.width!)




		//android style里面的border-radius 覆盖不了css里面的值
		if (props.radius != null) {
			css.set('border-radius', props.radius!)
		} else if (props.mode == 'half-round') {
			css.set('border-radius', '999px 0 0 999px')
		} else {
			css.set('border-radius', '999px')
		}

		return css
	})

	const _textColor = computed(() => {
		if (hasStrValue(props.textColor)) return props.textColor!



		return ""
	})

	const textStyle = computed(() => {
		const css = new Map<string, string>()
		if (hasStrValue(props.textColor)) css.set('color', props.textColor!)
		if (props.textSize != null) css.set('font-size', addUnit(props.textSize!))
		return css
	})

	const backTopCss = computed(() => {
		const mode = ['round', 'half-round'].includes(props.mode) ? props.mode : 'round'
		return [
			ns.b(""),
			ns.theme(),
			ns.m(mode),
			ns.is('zoom', props.zoom),
			ns.is('show', isShow.value),



		]
	})

return (): any | null => {

const _component_rice_icon = resolveEasyComponent("rice-icon",_easycom_rice_icon)

  return _cE("view", _uM({
    class: _nC(unref(backTopCss)),
    style: _nS([unref(backTopStyle),_ctx.customStyle]),
    ref_key: "backTopRef",
    ref: backTopRef,
    onClick: backToTop
  }), [
    renderSlot(_ctx.$slots, "default", {}, (): any[] => [
      isTrue(unref(hasStrValue)(_ctx.icon))
        ? _cV(_component_rice_icon, _uM({
            key: 0,
            name: _ctx.icon,
            size: unref(_iconSize),
            color: unref(_textColor),
            bold: ""
          }), null, 8 /* PROPS */, ["name", "size", "color"])
        : _cC("v-if", true),
      isTrue(unref(hasStrValue)(_ctx.text))
        ? _cE("text", _uM({
            key: 1,
            class: _nC(["rice-back-top__text", _uM({'rice-back-top--half-round__text':_ctx.mode=='half-round'})]),
            style: _nS(unref(textStyle))
          }), _tD(_ctx.text), 7 /* TEXT, CLASS, STYLE */)
        : _cC("v-if", true)
    ])
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
export type RiceBackTopComponentPublicInstance = InstanceType<typeof __sfc__>;
const GenUniModulesRiceUiComponentsRiceBackTopRiceBackTopStyles = [_uM([["rice-back-top", _pS(_uM([["position", "fixed"], ["alignItems", "center"], ["justifyContent", "center"], ["opacity", 0], ["zIndex", 998], ["transitionProperty", "transform,opacity"], ["transitionDuration", "0.3s"], ["transitionTimingFunction", "cubic-bezier(0.25,0.8,0.5,1)"], ["borderTopWidth", 1], ["borderRightWidth", 1], ["borderBottomWidth", 1], ["borderLeftWidth", 1], ["borderTopStyle", "solid"], ["borderRightStyle", "solid"], ["borderBottomStyle", "solid"], ["borderLeftStyle", "solid"], ["borderTopColor", "var(--rice-border-color)"], ["borderRightColor", "var(--rice-border-color)"], ["borderBottomColor", "var(--rice-border-color)"], ["borderLeftColor", "var(--rice-border-color)"], ["bottom", 100], ["right", 20], ["backgroundColor", "var(--rice-back-top-background)"]]))], ["rice-back-top--round", _pS(_uM([["right", 20], ["height", 48], ["width", 48]]))], ["rice-back-top--half-round", _pS(_uM([["flexDirection", "row"], ["right", 0], ["width", 64], ["height", 40]]))], ["rice-back-top--half-round__text", _pS(_uM([["width", 25], ["marginLeft", 2]]))], ["rice-back-top--zoom", _pS(_uM([["transform", "scale(0)"]]))], ["rice-back-top--show", _pS(_uM([["transform", "scale(1)"], ["opacity", 1]]))], ["rice-back-top__text", _pS(_uM([["color", "var(--rice-text-color)"], ["fontSize", 10]]))], ["rice-icon", _uM([[".rice-back-top ", _uM([["color", "var(--rice-text-color)"]])]])], ["@TRANSITION", _uM([["rice-back-top", _uM([["property", "transform,opacity"], ["duration", "0.3s"], ["timingFunction", "cubic-bezier(0.25,0.8,0.5,1)"]])]])]])]
