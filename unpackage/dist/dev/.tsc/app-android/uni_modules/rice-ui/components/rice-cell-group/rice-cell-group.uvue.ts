import { hasStrValue, addUnit } from "../../libs/utils"
	import { useNamespace } from "../../libs/use"
	import { CellGroupProps } from "./type.uts"

	
const __sfc__ = defineComponent({
  __name: 'rice-cell-group',

		name: 'rice-cell-group'
	,
  props: {
    title: { type: [String, Number], required: false },
    border: { type: Boolean, required: false, default: false },
    radius: { type: [String, Number], required: false },
    titleStyle: { type: UTSJSONObject, required: false, default: () : UTSJSONObject => ({}) },
    customStyle: { type: UTSJSONObject, required: false, default: () : UTSJSONObject => ({}) }
  },
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	/**
	 * @description rice-cell-group 单元格为列表中的单个展示项。
	 * @property {String|Number} title 分组标题
	 * @property {Boolean} border 是否显示上下边框，默认false
	 * @property {String|Number} radius 圆角值
	 * @property {Object} titleStyle 标题文字样式 
	 * @property {Object} customStyle 自定义样式
	 */
	

	const ns = useNamespace("cell-group")

	const props = __props

	const cellGroupStyle = computed(() => {
		const css = new Map<string, string>()
		if (props.radius != null) {
			css.set('border-radius', addUnit(props.radius!))
		}
		return css
	})

	const cellGroupClass = computed(() => {
		return [
			ns.b(""),
			ns.theme(),
			ns.is('border', props.border)
		]
	})

	const cellGroupTitleClass = computed(() => {
		return [
			ns.theme(),
		]
	})

return (): any | null => {

  return _cE(Fragment, null, [
    isTrue(unref(hasStrValue)(_ctx.title))
      ? _cE("text", _uM({
          key: 0,
          class: _nC(["rice-cell-group__title", unref(cellGroupTitleClass)]),
          style: _nS(_ctx.titleStyle)
        }), _tD(_ctx.title), 7 /* TEXT, CLASS, STYLE */)
      : _cC("v-if", true),
    _cE("view", _uM({
      class: _nC(unref(cellGroupClass)),
      style: _nS([unref(cellGroupStyle),_ctx.customStyle])
    }), [
      renderSlot(_ctx.$slots, "default")
    ], 6 /* CLASS, STYLE */)
  ], 64 /* STABLE_FRAGMENT */)
}
}

})
export default __sfc__
export type RiceCellGroupComponentPublicInstance = InstanceType<typeof __sfc__>;
const GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroupStyles = [_uM([["rice-cell-group", _pS(_uM([["backgroundColor", "var(--rice-cell-background)"]]))], ["rice-cell-group__title", _pS(_uM([["paddingTop", "var(--rice-padding-md)"], ["paddingRight", "var(--rice-padding-md)"], ["paddingBottom", "var(--rice-padding-md)"], ["paddingLeft", "var(--rice-padding-md)"], ["color", "var(--rice-text-color-2)"], ["fontSize", "var(--rice-font-size-basic)"]]))], ["rice-cell-group--border", _pS(_uM([["borderBottomWidth", "1rpx"], ["borderBottomStyle", "solid"], ["borderBottomColor", "var(--rice-border-color)"], ["borderTopWidth", "1rpx"], ["borderTopStyle", "solid"], ["borderTopColor", "var(--rice-border-color)"]]))]])]
