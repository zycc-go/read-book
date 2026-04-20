import { useNamespace } from "../../libs/use"
	import { isDark } from "../../libs/store"
	import { hasStrValue, addUnit } from "../../libs/utils"
	import { formDisabledInjectKey, formReadonlyInjectKey } from "../rice-form"
	import { formItemBlurInjectKey } from "../rice-form-item"
	import { TextareaProps } from "./type.uts"
	
const __sfc__ = defineComponent({
  __name: 'rice-textarea',

		name: 'rice-textarea'
	,
  props: /*#__PURE__*/mergeModels({
    disabled: { type: Boolean, required: false },
    readonly: { type: Boolean, required: false },
    placeholder: { type: String, required: false },
    placeholderStyle: { type: String, required: false },
    maxlength: { type: Number, required: false, default: -1 },
    cursorSpacing: { type: Number, required: false, default: 0 },
    cursorColor: { type: String, required: false },
    autoFocus: { type: Boolean, required: false, default: false },
    focus: { type: Boolean, required: false, default: false },
    confirmType: { type: String, required: false, default: 'return' },
    confirmHold: { type: Boolean, required: false, default: false },
    autoHeight: { type: Boolean, required: false, default: false },
    cursor: { type: Number, required: false, default: 0 },
    selectionStart: { type: Number, required: false, default: -1 },
    selectionEnd: { type: Number, required: false, default: -1 },
    adjustPosition: { type: Boolean, required: false, default: true },
    inputmode: { type: String, required: false },
    holdKeyboard: { type: Boolean, required: false, default: false },
    fixed: { type: Boolean, required: false },
    showConfirmBar: { type: Boolean, required: false },
    disableDefaultPadding: { type: Boolean, required: false },
    height: { type: [String, Number], required: false, default: '90px' },
    minHeight: { type: [String, Number], required: false },
    maxHeight: { type: [String, Number], required: false },
    color: { type: String, required: false },
    fontSize: { type: [String, Number], required: false },
    showWordLimit: { type: Boolean, required: false, default: false },
    border: { type: String, required: false, default: 'surround' },
    bgColor: { type: String, required: false },
    textareaAlign: { type: String, required: false },
    textareaStyle: { type: UTSJSONObject, required: false, default: () : UTSJSONObject => ({}) },
    customStyle: { type: UTSJSONObject, required: false, default: () : UTSJSONObject => ({}) }
  }, {
    "modelValue": {
		type: String,
		default: ""
	},
  }),
  emits: /*#__PURE__*/mergeModels(["input", "focus", "blur", "keyboardheightchange", "change", "linechange"], ["update:modelValue"]),
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	/**
	 * @description Input
	 * @property {String} modelValue 输入框的值
	 * @property {Boolean} disabled 是否禁用
	 * @property {Boolean} readonly 是否只读，默认false
	 * @property {String} placeholder 输入框为空时占位符
	 * @property {String} placeholderStyle 指定 placeholder 的样式
	 * @property {Number} maxlength 最大输入长度，0和正数为合法值，非法值的时候不限制最大长度,默认-1，不限制
	 * @property {Number} cursorSpacing 指定光标与键盘的距离，单位 px 。取 input 距离底部的距离和 cursor-spacing 指定的距离的最小值作为光标与键盘的距离
	 * @property {String} cursorColor 指定光标颜色，Android的微信小程序非skyline下仅支持黑和绿，iOS版仅支持十六进制颜色值
	 * @property {Boolean} autoFocus 自动获取焦点，与focus属性对比，此属性只会首次生效
	 * @property {Boolean} focus 获取焦点
	 * @property {String} confirmType 设置键盘右下角按钮的文字
	 * @value return 下一行 （默认值）
	 * @value done 完成
	 * @value send 发送
	 * @value search 搜索
	 * @value next 下一个
	 * @value go 前往
	 * @property {Boolean} confirmHold 点击键盘右下角按钮时是否保持键盘不收起
	 * @property {Boolean} autoHeight 是否自动增高，设置auto-height时，style.height不生效
	 * @property {Number} cursor 指定focus时的光标位置
	 * @property {Number} selectionStart 光标起始位置，自动聚集时有效，需与selection-end搭配使用
	 * @property {Number} selectionEnd 光标结束位置，自动聚集时有效，需与selection-satrt搭配使用
	 * @property {Boolean} adjustPosition 键盘弹起时，是否自动上推页面,默认true
	 * @property {String} inputmode 是一个枚举属性，它提供了用户在编辑元素或其内容时可能输入的数据类型的提示，仅支持web，默认会根据type自动适配
	 * @property {Boolean} holdKeyboard focus时，点击页面的时候不收起键盘,默认false
	 * @property {Boolean} fixed 如果 textarea 是在一个 position:fixed 的区域，需要显示指定属性 fixed 为 true，仅支持微信小程序
	 * @property {Boolean} showConfirmBar 是否显示键盘上方带有”完成“按钮那一栏，仅支持微信小程序
	 * @property {Boolean} disableDefaultPadding 是否去掉 iOS 下的默认内边距，仅支持微信小程序
	 * @property {String|Number} height 高度
	 * @property {String|Number} minHeight 最小高度
	 * @property {String|Number} maxHeight 最大高度
	 * @property {String} color 输入框字体颜色
	 * @property {String|Number} fontSize 输入框字体大小
	 * @property {Boolean} showWordLimit 是否显示字数统计
	 * @property {String} border 输入框的边框
	 * @value surround 全边框（默认值）
	 * @value bottom 下边框
	 * @value none 无边框
	 * @property {String} bgColor 背景颜色
	 * @property {String} textareaAlign 输入框对齐方式，默认left,可选 right|center
	 * @property {Object} textareaStyle 自定义input样式
	 * @property {Object} customStyle 自定义样式
	 */

	
	const ns = useNamespace("textarea")
	function emit(event: string, ...do_not_transform_spread: Array<any | null>) {
__ins.emit(event, ...do_not_transform_spread)
}

	const props = __props

	const modelValue = useModel<String>(__ins.props, "modelValue")

	const isFocus = ref(false)
	const showPasswordValue = ref(false)

	const formDisabled = inject<Ref<boolean | null> | null>(formDisabledInjectKey, null)
	const formReadonly = inject<Ref<boolean | null> | null>(formReadonlyInjectKey, null)
	const formItemBlur = inject<(() => void) | null>(formItemBlurInjectKey, null)

	const isDisabled = computed<boolean>(() => (formDisabled?.value ?? false) || (props.disabled ?? false))
	const isReadonly = computed<boolean>(() => (formReadonly?.value ?? false) || (props.readonly ?? false))

	const onClear = () => {
		if (isDisabled.value || isReadonly.value) return
		modelValue.value = ""
	}

	const onInput = (e : UniInputEvent) => {
		emit('input', e.detail.value)
	}

	const onFocus = (e : UniTextareaFocusEvent) => {
		isFocus.value = true
		emit('focus', e)
	}

	let timer : null | number = null
	const onBlur = (e : UniTextareaBlurEvent) => {
		//加个延迟，防止web等端清除按钮点击不到
		timer = setTimeout(() => {
			isFocus.value = false
			emit('blur', e)
		}, 100)
		formItemBlur?.()
	}

	const onKeyboardheightchange = (e : UniInputKeyboardHeightChangeEvent) => {
		emit('keyboardheightchange', e)
	}

	const onChange = (e : UniInputChangeEvent) => {
		emit('change', e.detail.value)
	}

	const onLinechange = (e : UniTextareaLineChangeEvent) => {
		emit('linechange', e)
	}

	const bgcolorStyle = computed(() => {
		const css = new Map<string, string>()
		if (hasStrValue(props.bgColor)) {
			css.set('background-color', props.bgColor!)
		}
		return css
	})

	const customTextareaStyle = computed(() => {
		const css = new Map<string, string>()
		if (hasStrValue(props.color)) {
			css.set('color', props.color!)
		}
		if (hasStrValue(props.fontSize)) {
			css.set('font-size', addUnit(props.fontSize!))
		}
		css.set('height', addUnit(props.height!))
		if (props.maxHeight != null) {
			css.set('max-height', addUnit(props.maxHeight!))
		}
		if (props.minHeight != null) {
			css.set('min-height', addUnit(props.minHeight!))
		}
		return css
	})

	const textareaClass = computed(() => {
		return [
			ns.b(""),
			ns.theme(),
			ns.is("disabled", isDisabled.value),
			ns.m(props.border),
		]
	})

	const textareaInnerClass = computed(() => {
		return [
			ns.e('textarea'),
			ns.is("__textarea--disabled", isDisabled.value),
			ns.e(`textarea--${props.textareaAlign ?? 'left'}`),
		]
	})

	const countClass = computed(() => {
		return [
			ns.e('count'),
			ns.is('__count--disabled', isDisabled.value)
		]
	})

	const _placeholderStyle = computed(() => {
		let baseColor = isDark.value ? '#4d4d4d' : '#c8c9cc'
		let css = `color:${baseColor};font-size:${addUnit(props.fontSize ?? '15px')};`
		return css + (props.placeholderStyle ?? "")
	})

	onUnmounted(() => {
		if (timer != null) clearTimeout(timer!)
	})

return (): any | null => {

  return _cE("view", _uM({
    class: _nC(unref(textareaClass)),
    style: _nS([unref(bgcolorStyle),_ctx.customStyle])
  }), [
    _cE("textarea", _uM({
      modelValue: modelValue.value,
      onInput: [($event: UniInputEvent) => {(modelValue).value = $event.detail.value}, onInput] as Array<any | null>,
      inputmode: _ctx.inputmode,
      placeholder: _ctx.placeholder,
      disabled: unref(isDisabled)||unref(isReadonly),
      maxlength: _ctx.maxlength,
      "placeholder-style": unref(_placeholderStyle),
      "cursor-spacing": _ctx.cursorSpacing,
      "cursor-color": _ctx.cursorColor,
      "auto-focus": _ctx.autoFocus,
      focus: _ctx.focus,
      "confirm-type": _ctx.confirmType,
      "confirm-hold": _ctx.confirmHold,
      cursor: _ctx.cursor,
      "selection-start": _ctx.selectionStart,
      "selection-end": _ctx.selectionEnd,
      "adjust-position": _ctx.adjustPosition,
      "hold-keyboard": _ctx.holdKeyboard,
      fixed: _ctx.fixed,
      "show-confirm-bar": _ctx.showConfirmBar,
      "disable-default-padding": _ctx.disableDefaultPadding,
      "auto-height": _ctx.autoHeight,
      class: _nC(unref(textareaInnerClass)),
      style: _nS([unref(customTextareaStyle),_ctx.textareaStyle]),
      onFocus: onFocus,
      onBlur: onBlur,
      onKeyboardheightchange: onKeyboardheightchange,
      onChange: onChange,
      onLinechange: onLinechange
    }), null, 46 /* CLASS, STYLE, PROPS, NEED_HYDRATION */, ["modelValue", "onInput", "inputmode", "placeholder", "disabled", "maxlength", "placeholder-style", "cursor-spacing", "cursor-color", "auto-focus", "focus", "confirm-type", "confirm-hold", "cursor", "selection-start", "selection-end", "adjust-position", "hold-keyboard", "fixed", "show-confirm-bar", "disable-default-padding", "auto-height"]),
    isTrue(_ctx.showWordLimit&&_ctx.maxlength>=0)
      ? _cE("text", _uM({
          key: 0,
          class: _nC(unref(countClass)),
          style: _nS(unref(bgcolorStyle))
        }), _tD(modelValue.value!.length) + "/" + _tD(_ctx.maxlength), 7 /* TEXT, CLASS, STYLE */)
      : _cC("v-if", true)
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
export type RiceTextareaComponentPublicInstance = InstanceType<typeof __sfc__>;
const GenUniModulesRiceUiComponentsRiceTextareaRiceTextareaStyles = [_uM([["rice-textarea", _pS(_uM([["position", "relative"], ["borderTopLeftRadius", 4], ["borderTopRightRadius", 4], ["borderBottomRightRadius", 4], ["borderBottomLeftRadius", 4], ["backgroundColor", "var(--rice-textarea-background)"], ["paddingTop", 10], ["paddingRight", 10], ["paddingBottom", 10], ["paddingLeft", 10]]))], ["rice-textarea__textarea", _pS(_uM([["textAlign", "left"], ["fontSize", "var(--rice-font-size-basic)"], ["color", "var(--rice-text-color)"], ["width", "100%"]]))], ["rice-textarea__textarea--disabled", _pS(_uM([["color", "var(--rice-textarea-disabled-text-color)"]]))], ["rice-textarea__textarea--center", _pS(_uM([["textAlign", "center"]]))], ["rice-textarea__textarea--right", _pS(_uM([["textAlign", "right"]]))], ["rice-textarea__count", _pS(_uM([["position", "absolute"], ["right", 5], ["bottom", 2], ["fontSize", 12], ["backgroundColor", "var(--rice-textarea-background)"], ["color", "var(--rice-text-color-2)"], ["paddingTop", 1], ["paddingRight", 4], ["paddingBottom", 1], ["paddingLeft", 4]]))], ["rice-textarea__count--disabled", _pS(_uM([["backgroundColor", "var(--rice-textarea-disabled-background)"], ["color", "var(--rice-textarea-disabled-text-color)"]]))], ["rice-textarea--surround", _pS(_uM([["borderTopLeftRadius", 4], ["borderTopRightRadius", 4], ["borderBottomRightRadius", 4], ["borderBottomLeftRadius", 4], ["borderTopWidth", 1], ["borderRightWidth", 1], ["borderBottomWidth", 1], ["borderLeftWidth", 1], ["borderTopStyle", "solid"], ["borderRightStyle", "solid"], ["borderBottomStyle", "solid"], ["borderLeftStyle", "solid"], ["borderTopColor", "var(--rice-textarea-border-color)"], ["borderRightColor", "var(--rice-textarea-border-color)"], ["borderBottomColor", "var(--rice-textarea-border-color)"], ["borderLeftColor", "var(--rice-textarea-border-color)"]]))], ["rice-textarea--bottom", _pS(_uM([["borderBottomWidth", 1], ["borderBottomStyle", "solid"], ["borderBottomColor", "var(--rice-textarea-border-color)"]]))], ["rice-textarea--disabled", _pS(_uM([["backgroundColor", "var(--rice-textarea-disabled-background)"]]))]])]
