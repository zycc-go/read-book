import _easycom_rice_icon from '@/uni_modules/rice-ui/components/rice-icon/rice-icon.uvue'
import { addUnit, hasStrValue, getPxNum, isThemeColor } from '../../libs/utils';
	import { useNamespace } from '../../libs/use';
	import { Coloruts } from "../../libs/plugin"
	import { LoadingProps, LoadingMode, LoadingTimingFunction } from './type.uts';

	import { useLoading, UseLoadingOptions } from './use-loading';


	
const __sfc__ = defineComponent({
  __name: 'rice-loading',

		name: 'rice-loading'
	,
  props: {
    mode: { type: String, required: false, default: 'circular' },
    duration: { type: Number, required: false, default: 1100 },
    color: { type: String, required: false, default: '#1989fa' },
    inactiveColor: { type: String, required: false },
    size: { type: [String, Number], required: false, default: '24px' },
    text: { type: [String, Number], required: false },
    textColor: { type: String, required: false },
    textSize: { type: [String, Number], required: false },
    vertical: { type: Boolean, required: false, default: false },
    timingFunction: { type: String, required: false, default: 'ease-in-out' },
    customStyle: { type: UTSJSONObject, required: false, default: () : UTSJSONObject => ({}) }
  },
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	/**
	 * @description rice-loading
	 * @property {String} mode 类型，可选 雪花 `snow`  半圆`semicircle` 圆 `circle`，默认 circular
	 * @value circular circular
	 * @value snow 雪花
	 * @value semicircle 半圆
	 * @value circle 圆
	 * @property {Number} duration 过渡时间，单位ms，默认 1000
	 * @property {String} color 颜色
	 * @property {String} inactiveColor 图标的暗边颜色, mode为circle 模式有效
	 * @property {Stiring|Number} size 加载图标大小 默认 24px
	 * @property {String|Number} text 加载文字
	 * @property {String} textColor 文字颜色
	 * @property {String| Number} textSize 文字大小 默认 14px;
	 * @property {Boolean} vertical 是否垂直排列图标和文字内容 默认false
	 * @property {String} timingFunction 指定animation-timing-function的css属性，mode为circle或semicircle时有效,默认 ease-in-out
	 * @property {Object} customStyle 自定义style
	 */
	

	const slot = useSlots()

	const ns = useNamespace('loading')
	const props = __props

	const hasText = computed(() => hasStrValue(props.text) || slot['default'] != null)
	const color = computed(() => hasStrValue(props.color) ? props.color! : '#1989fa')





	const loadingRef = shallowRef<UniElement | null>(null)
	const coreRef = shallowRef<UniElement | null>(null)
	const circularRef = ref<UniElement | null>(null)
	const animationTimingFn = computed(() => (props.mode == 'snow' || slot['icon'] != null) ? 'linear' : props.timingFunction)

	useLoading({
		loadingRef,
		coreRef,
		circularRef,
		mode: props.mode,
		timingFunction: animationTimingFn.value,
		color: color,
		size: toRef<string | number>(() => props.size),
		duration: props.duration,
	} as UseLoadingOptions)



	const circularStyle = computed(() => {
		const css = new Map<string, string>()
		const size = addUnit(props.size!)
		css.set('height', size)
		css.set('width', size)
		return css
	})

	const semicircleStyle = computed(() => {
		const css = new Map<string, string>()
		const size = addUnit(props.size!)
		css.set('height', size)
		css.set('width', size)
		const hasColor = hasStrValue(props.color)
		if (props.mode == 'circle') {
			if (hasStrValue(props.inactiveColor)) {
				css.set('border-color', props.inactiveColor!)
			} else if (hasColor && props.color != 'inherit') {
				const rgb = new Coloruts(props.color!).toRgb()
				css.set('border-color', `rgba(${rgb['r']},${rgb['g']},${rgb['b']},.2)`)
			}
		}
		css.set('border-top-color', color.value)





		return css
	})

	const textStyle = computed(() => {
		const css = new Map<string, string>()
		if (props.vertical) {
			css.set('margin-top', '8px')
		} else {
			css.set('margin-left', '8px')
		}
		if (hasStrValue(props.textColor)) {
			css.set('color', props.textColor!)
		}
		if (hasStrValue(props.textSize)) {
			css.set('font-size', addUnit(props.textSize!))
		}
		return css
	})

	const loadingClass = computed(() => {
		return [
			ns.b(""),
			ns.theme(),
			ns.is("vertical", props.vertical),
			ns.is("slot", slot['icon'] != null)
		]
	})

return (): any | null => {

const _component_rice_icon = resolveEasyComponent("rice-icon",_easycom_rice_icon)

  return _cE("view", _uM({
    class: _nC(unref(loadingClass)),
    style: _nS(_ctx.customStyle),
    ref_key: "loadingRef",
    ref: loadingRef
  }), [
    isTrue(_ctx.mode=='snow' || unref(slot)['icon']!=null)
      ? _cE("view", _uM({
          key: 0,
          class: _nC(unref(ns).m('snow')),
          ref_key: "coreRef",
          ref: coreRef
        }), [
          renderSlot(_ctx.$slots, "icon", {}, (): any[] => [
            _cV(_component_rice_icon, _uM({
              name: "loading",
              size: _ctx.size,
              color: unref(color),
              type: "primary"
            }), null, 8 /* PROPS */, ["size", "color"])
          ])
        ], 2 /* CLASS */)
      : isTrue(_ctx.mode=='semicircle'||_ctx.mode=='circle')
        ? _cE("view", _uM({
            key: 1,
            class: _nC(unref(ns).m(_ctx.mode)),
            style: _nS(unref(semicircleStyle)),
            ref_key: "coreRef",
            ref: coreRef
          }), null, 6 /* CLASS, STYLE */)
        : _cE("view", _uM({
            key: 2,
            class: _nC(unref(ns).m('circular')),
            style: _nS(unref(circularStyle)),
            ref_key: "circularRef",
            ref: circularRef
          }), null, 6 /* CLASS, STYLE */),
    isTrue(unref(hasText))
      ? _cE("text", _uM({
          key: 3,
          class: _nC(unref(ns).e('text')),
          style: _nS(unref(textStyle))
        }), [
          renderSlot(_ctx.$slots, "default", {}, (): any[] => [_tD(_ctx.text)])
        ], 6 /* CLASS, STYLE */)
      : _cC("v-if", true)
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
export type RiceLoadingComponentPublicInstance = InstanceType<typeof __sfc__>;
const GenUniModulesRiceUiComponentsRiceLoadingRiceLoadingStyles = [_uM([["rice-loading", _pS(_uM([["flexDirection", "row"], ["alignItems", "center"]]))], ["rice-loading--vertical", _pS(_uM([["flexDirection", "column"], ["justifyContent", "center"]]))], ["rice-loading--slot", _pS(_uM([["overflow", "visible"]]))], ["rice-loading--semicircle", _pS(_uM([["borderTopLeftRadius", 999], ["borderTopRightRadius", 999], ["borderBottomRightRadius", 999], ["borderBottomLeftRadius", 999], ["borderTopWidth", 2], ["borderRightWidth", 2], ["borderBottomWidth", 2], ["borderLeftWidth", 2], ["borderTopStyle", "solid"], ["borderRightStyle", "solid"], ["borderBottomStyle", "solid"], ["borderLeftStyle", "solid"], ["borderTopColor", "rgba(0,0,0,0)"], ["borderRightColor", "rgba(0,0,0,0)"], ["borderBottomColor", "rgba(0,0,0,0)"], ["borderLeftColor", "rgba(0,0,0,0)"]]))], ["rice-loading--circle", _pS(_uM([["borderTopLeftRadius", 999], ["borderTopRightRadius", 999], ["borderBottomRightRadius", 999], ["borderBottomLeftRadius", 999], ["borderTopWidth", 2], ["borderRightWidth", 2], ["borderBottomWidth", 2], ["borderLeftWidth", 2], ["borderTopStyle", "solid"], ["borderRightStyle", "solid"], ["borderBottomStyle", "solid"], ["borderLeftStyle", "solid"], ["borderTopColor", "rgba(25,136,249,0.2)"], ["borderRightColor", "rgba(25,136,249,0.2)"], ["borderBottomColor", "rgba(25,136,249,0.2)"], ["borderLeftColor", "rgba(25,136,249,0.2)"]]))], ["rice-loading__text", _pS(_uM([["fontSize", "var(--rice-font-size-sm)"], ["color", "var(--rice-text-color-2)"]]))]])]
