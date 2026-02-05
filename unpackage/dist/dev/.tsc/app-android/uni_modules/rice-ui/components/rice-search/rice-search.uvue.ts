import _easycom_rice_icon from '@/uni_modules/rice-ui/components/rice-icon/rice-icon.uvue'
import { useNamespace } from '../../libs/use';
	import { isDark } from "../../libs/store";
	import { addUnit, hasStrValue } from "../../libs/utils";
	import { SearchProps } from './type.uts';

	
const __sfc__ = defineComponent({
  __name: 'rice-search',

		name: 'rice-search'
	,
  props: /*#__PURE__*/mergeModels({
    label: { type: String, required: false },
    shape: { type: String, required: false, default: 'square' },
    bgColor: { type: String, required: false },
    inputColor: { type: String, required: false },
    fontSize: { type: [String, Number], required: false },
    color: { type: String, required: false },
    height: { type: [String, Number], required: false },
    maxlength: { type: Number, required: false, default: -1 },
    holdKeyboard: { type: Boolean, required: false, default: false },
    placeholder: { type: String, required: false, default: '请输入搜索关键字' },
    placeholderStyle: { type: String, required: false },
    focus: { type: Boolean, required: false, default: false },
    clearable: { type: Boolean, required: false, default: true },
    clearIcon: { type: String, required: false, default: 'clear' },
    clearTrigger: { type: String, required: false, default: 'focus' },
    showAction: { type: Boolean, required: false, default: false },
    actionText: { type: String, required: false, default: '搜索' },
    actionSize: { type: [String, Number], required: false },
    actionColor: { type: String, required: false },
    disabled: { type: Boolean, required: false, default: false },
    inputAlign: { type: String, required: false, default: 'left' },
    leftIcon: { type: String, required: false, default: 'search' },
    rightIcon: { type: String, required: false },
    leftIconSize: { type: [String, Number], required: false, default: '16px' },
    leftIconColor: { type: String, required: false },
    rightIconSize: { type: [String, Number], required: false, default: '16px' },
    rightIconColor: { type: String, required: false },
    customStyle: { type: UTSJSONObject, required: false, default: () : UTSJSONObject => ({}) }
  }, {
    "modelValue": {
		type: String,
		default: ""
	},
  }),
  emits: /*#__PURE__*/mergeModels(["input", "search", "focus", "blur", "keyboardheightchange", "clickInput", "clickLeftIcon", "clickRightIcon", "clickAction", "clear"], ["update:modelValue"]),
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	/**
 * @description Search
 * @property {String} modelValue 绑定的值
 * @property {String} label 搜索框左侧文本
 * @property {String} shape 搜索框形状
 * @value square 方形（默认值）
 * @value round 圆角
 * @property {String} bgColor 搜索框外部背景色
 * @property {String} inputColor 搜索框的背景颜色
 * @property {String|Number} fontSize 输入框字体大小
 * @property {String} color 输入框字体颜色
 * @property {String|Number} height 输入框的高度
 * @property {Number} maxlength 输入的最大字符数
 * @property {Boolean} holdKeyboard focus时，点击页面的时候不收起键盘
 * @property {String} placeholder 占位提示文字
 * @property {String} placeholderStyle 指定 placeholder 的样式
 * @property {Boolean} focus 是否聚焦
 * @property {Boolean} clearable 是否启用清除图标，默认true
 * @property {String} clearIcon 清除图标的name值
 * @property {String} clearTrigger 显示清除图标的时机
 * @value always 输入框值不为空时展示
 * @value focus 输入框值不为空且聚焦时显示（默认值）
 * @property {Boolean} showAction 是否在搜索框右侧显示搜索按钮
 * @property {String} actionText 按钮的文字默认 搜索
 * @property {String|Number} actionSize 按钮文字的大小
 * @property {String} actionColor 按钮文字的颜色
 * @property {Boolean} disabled 是否禁用
 * @property {String} inputAlign 输入框对齐方式
 * @value left 左对齐 （默认值）
 * @value center 居中对齐
 * @value right 右对齐
 * @property {String} leftIcon 输入框左侧图标名称，为空字符串时不展示
 * @property {String} rightIcon 输入框右侧图标名称，为空字符串时不展示
 * @property {String|Number} leftIconSize 左侧图标大小
 * @property {String} leftIconColor 左侧图标颜色
 * @property {String|Number} rightIconSize 左侧图标大小
 * @property {String} rightIconColor 右侧图标颜色
 * @property {Object} customStyle 自定义样式
 */
	

	const ns = useNamespace('search')
	function emit(event: string, ...do_not_transform_spread: Array<any | null>) {
__ins.emit(event, ...do_not_transform_spread)
}

	const props = __props

	const modelValue = useModel<String>(__ins.props, "modelValue")

	const isFocus = ref(false)

	const isShowClearable = computed<boolean>(() => {
		if (props.disabled) return false
		const shouldTrigger = props.clearTrigger == 'focus' ? isFocus.value : true
		return props.clearable && modelValue.value != "" && shouldTrigger
	})

	const onClear = () => {
		if (props.disabled) return
		modelValue.value = ""
		emit('clear')
	}

	const handleClick = (e : UniPointerEvent) => {
		emit('clickInput', e)
	}

	const onInput = (e : UniInputEvent) => {
		emit('input', e.detail.value)
	}

	const onFocus = (e : UniInputFocusEvent) => {
		isFocus.value = true
		emit('focus', e)
	}

	let timer : null | number = null
	const onBlur = (e : UniInputBlurEvent) => {
		//加个延迟，防止web等端清除按钮点击不到
		timer = setTimeout(() => {
			isFocus.value = false
			emit('blur', e)
		}, 100)

	}

	const onConfirm = (e : UniInputConfirmEvent) => {
		emit('search', e.detail.value)
	}

	const onKeyboardheightchange = (e : UniInputKeyboardHeightChangeEvent) => {
		emit('keyboardheightchange', e)
	}

	const clickLeftIcon = () => {
		emit('clickLeftIcon', modelValue.value)
	}

	const clickRightIcon = () => {
		emit('clickRightIcon', modelValue.value)
	}

	const clickAction = () => {
		emit('clickAction', modelValue.value)
	}

	const searchStyle = computed(() => {
		const css = new Map<string, string>()
		if (hasStrValue(props.bgColor)) css.set('background-color', props.bgColor!)
		return css
	})

	const wrapperStyle = computed(() => {
		const css = new Map<string, string>()
		if (props.height != null) css.set('height', addUnit(props.height!))
		if (hasStrValue(props.inputColor)) css.set('background-color', props.inputColor!)
		return css
	})

	const inputStyle = computed(() => {
		const css = new Map<string, string>()
		if (props.fontSize != null) css.set('font-size', addUnit(props.fontSize!))
		if (hasStrValue(props.color)) css.set('color', props.color!)
		return css
	})

	const actionStyle = computed(() => {
		const css = new Map<string, string>()
		if (props.actionSize != null) css.set('font-size', addUnit(props.actionSize!))
		if (hasStrValue(props.actionColor)) css.set('color', props.actionColor!)
		return css
	})

	const inputClass = computed(() => {
		return [
			ns.e('wrapper__input'),
			ns.e(`wrapper__input--${props.inputAlign}`),
		]
	})

	const _placeholderStyle = computed(() => {
		let baseColor = isDark.value ? '#4d4d4d' : '#c8c9cc'
		let css = `color:${baseColor};font-size:${addUnit(props.fontSize ?? '15px')};`
		return css + (props.placeholderStyle ?? "")
	})

	const clearIconStyle = computed(() => {
		return {
			paddingLeft: '6px',
		}
	})

	const searchClass = computed(() => {
		return [
			ns.b(""),
			ns.theme(),



		]
	})

	const wrapperClass = computed(() => {
		return [
			ns.e("wrapper"),
			ns.e(`wrapper--${props.shape}`)
		]
	})

	onUnmounted(() => {
		if (timer != null) clearTimeout(timer!)
	})

return (): any | null => {

const _component_rice_icon = resolveEasyComponent("rice-icon",_easycom_rice_icon)

  return _cE("view", _uM({
    class: _nC(unref(searchClass)),
    style: _nS([unref(searchStyle),_ctx.customStyle])
  }), [
    renderSlot(_ctx.$slots, "left"),
    _cE("view", _uM({
      class: _nC(unref(wrapperClass)),
      style: _nS(unref(wrapperStyle))
    }), [
      isTrue(_ctx.$slots['label']!=null||unref(hasStrValue)(_ctx.label))
        ? renderSlot(_ctx.$slots, "label", _uM({ key: 0 }), (): any[] => [
            _cE("text", _uM({ class: "rice-search__label" }), _tD(_ctx.label), 1 /* TEXT */)
          ])
        : _cC("v-if", true),
      isTrue(_ctx.$slots['leftIcon']!=null||unref(hasStrValue)(_ctx.leftIcon))
        ? renderSlot(_ctx.$slots, "leftIcon", _uM({ key: 1 }), (): any[] => [
            _cV(_component_rice_icon, _uM({
              name: _ctx.leftIcon,
              size: _ctx.leftIconSize,
              color: _ctx.leftIconColor,
              onClick: clickLeftIcon
            }), null, 8 /* PROPS */, ["name", "size", "color"])
          ])
        : _cC("v-if", true),
      _cE("input", _uM({
        modelValue: modelValue.value,
        onInput: [($event: UniInputEvent) => {(modelValue).value = $event.detail.value}, onInput] as Array<any | null>,
        type: "search",
        inputmode: "search",
        maxlength: _ctx.maxlength,
        "confirm-type": "search",
        focus: _ctx.focus,
        disabled: _ctx.disabled,
        holdKeyboard: _ctx.holdKeyboard,
        placeholder: _ctx.placeholder,
        "placeholder-style": unref(_placeholderStyle),
        class: _nC(unref(inputClass)),
        style: _nS(unref(inputStyle)),
        onFocus: onFocus,
        onBlur: onBlur,
        onConfirm: onConfirm,
        onKeyboardheightchange: onKeyboardheightchange,
        onClick: handleClick
      }), null, 46 /* CLASS, STYLE, PROPS, NEED_HYDRATION */, ["modelValue", "onInput", "maxlength", "focus", "disabled", "holdKeyboard", "placeholder", "placeholder-style"]),
      isTrue(_ctx.$slots['rightIcon']!=null||unref(hasStrValue)(_ctx.rightIcon))
        ? renderSlot(_ctx.$slots, "rightIcon", _uM({ key: 2 }), (): any[] => [
            _cV(_component_rice_icon, _uM({
              name: _ctx.rightIcon,
              size: _ctx.rightIconSize,
              color: _ctx.rightIconColor,
              onClick: clickRightIcon
            }), null, 8 /* PROPS */, ["name", "size", "color"])
          ])
        : _cC("v-if", true),
      isTrue(unref(isShowClearable))
        ? _cV(_component_rice_icon, _uM({
            key: 3,
            name: _ctx.clearIcon,
            size: "17px",
            "custom-style": unref(clearIconStyle),
            onClick: onClear
          }), null, 8 /* PROPS */, ["name", "custom-style"])
        : _cC("v-if", true)
    ], 6 /* CLASS, STYLE */),
    isTrue(_ctx.showAction)
      ? renderSlot(_ctx.$slots, "action", _uM({ key: 0 }), (): any[] => [
          _cE("text", _uM({
            class: "rice-search__action",
            style: _nS(unref(actionStyle)),
            onClick: clickAction
          }), _tD(_ctx.actionText), 5 /* TEXT, STYLE */)
        ])
      : _cC("v-if", true)
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
export type RiceSearchComponentPublicInstance = InstanceType<typeof __sfc__>;
const GenUniModulesRiceUiComponentsRiceSearchRiceSearchStyles = [_uM([["rice-search", _pS(_uM([["flexDirection", "row"], ["alignItems", "center"], ["backgroundColor", "var(--rice-search-background)"], ["paddingTop", 10], ["paddingRight", 12], ["paddingBottom", 10], ["paddingLeft", 12]]))], ["rice-search__label", _pS(_uM([["paddingRight", 5], ["fontSize", "var(--rice-font-size-sm)"], ["color", "var(--rice-text-color)"]]))], ["rice-search__wrapper", _pS(_uM([["flexGrow", 1], ["flexShrink", 1], ["flexBasis", "0%"], ["flexDirection", "row"], ["alignItems", "center"], ["backgroundColor", "var(--rice-search-input-background)"], ["height", 36], ["paddingTop", 0], ["paddingRight", 10], ["paddingBottom", 0], ["paddingLeft", 10], ["borderTopLeftRadius", 4], ["borderTopRightRadius", 4], ["borderBottomRightRadius", 4], ["borderBottomLeftRadius", 4]]))], ["rice-search__wrapper__input", _pS(_uM([["flexGrow", 1], ["flexShrink", 1], ["flexBasis", "0%"], ["paddingTop", 0], ["paddingRight", 8], ["paddingBottom", 0], ["paddingLeft", 8], ["fontSize", "var(--rice-font-size-basic)"], ["color", "var(--rice-text-color)"], ["height", "100%"], ["textAlign", "left"]]))], ["rice-search__wrapper__input--center", _pS(_uM([["textAlign", "center"]]))], ["rice-search__wrapper__input--right", _pS(_uM([["textAlign", "right"]]))], ["rice-search__wrapper--round", _pS(_uM([["borderTopLeftRadius", 999], ["borderTopRightRadius", 999], ["borderBottomRightRadius", 999], ["borderBottomLeftRadius", 999]]))], ["rice-search__action", _pS(_uM([["paddingLeft", 10], ["fontSize", "var(--rice-font-size-sm)"], ["color", "var(--rice-text-color)"]]))]])]
