@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI4CF4B90
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
open class GenUniModulesRiceUiComponentsRiceTextareaRiceTextarea : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var disabled: Boolean? by `$props`
    open var readonly: Boolean? by `$props`
    open var placeholder: String? by `$props`
    open var placeholderStyle: String? by `$props`
    open var maxlength: Number by `$props`
    open var cursorSpacing: Number by `$props`
    open var cursorColor: String? by `$props`
    open var autoFocus: Boolean by `$props`
    open var focus: Boolean by `$props`
    open var confirmType: String by `$props`
    open var confirmHold: Boolean by `$props`
    open var autoHeight: Boolean by `$props`
    open var cursor: Number by `$props`
    open var selectionStart: Number by `$props`
    open var selectionEnd: Number by `$props`
    open var adjustPosition: Boolean by `$props`
    open var inputmode: String? by `$props`
    open var holdKeyboard: Boolean by `$props`
    open var fixed: Boolean? by `$props`
    open var showConfirmBar: Boolean? by `$props`
    open var disableDefaultPadding: Boolean? by `$props`
    open var height: Any by `$props`
    open var minHeight: Any? by `$props`
    open var maxHeight: Any? by `$props`
    open var color: String? by `$props`
    open var fontSize: Any? by `$props`
    open var showWordLimit: Boolean by `$props`
    open var border: String by `$props`
    open var bgColor: String? by `$props`
    open var textareaAlign: String? by `$props`
    open var textareaStyle: UTSJSONObject by `$props`
    open var customStyle: UTSJSONObject by `$props`
    open var modelValue: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceTextareaRiceTextarea) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceTextareaRiceTextarea
            val _cache = __ins.renderCache
            val ns = useNamespace("textarea")
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val modelValue = useModel<String>(__ins.props, "modelValue")
            val isFocus = ref(false)
            val showPasswordValue = ref(false)
            val formDisabled = inject<Ref<Boolean?>?>(formDisabledInjectKey, null)
            val formReadonly = inject<Ref<Boolean?>?>(formReadonlyInjectKey, null)
            val formItemBlur = inject<(() -> Unit)?>(formItemBlurInjectKey, null)
            val isDisabled = computed<Boolean>(fun(): Boolean {
                return (formDisabled?.value ?: false) || (props.disabled ?: false)
            }
            )
            val isReadonly = computed<Boolean>(fun(): Boolean {
                return (formReadonly?.value ?: false) || (props.readonly ?: false)
            }
            )
            val onInput = fun(e: UniInputEvent){
                emit("input", e.detail.value)
            }
            val onFocus = fun(e: UniTextareaFocusEvent){
                isFocus.value = true
                emit("focus", e)
            }
            var timer: Number? = null
            val onBlur = fun(e: UniTextareaBlurEvent){
                timer = setTimeout(fun(){
                    isFocus.value = false
                    emit("blur", e)
                }
                , 100)
                formItemBlur?.invoke()
            }
            val onKeyboardheightchange = fun(e: UniInputKeyboardHeightChangeEvent){
                emit("keyboardheightchange", e)
            }
            val onChange = fun(e: UniInputChangeEvent){
                emit("change", e.detail.value)
            }
            val onLinechange = fun(e: UniTextareaLineChangeEvent){
                emit("linechange", e)
            }
            val bgcolorStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.bgColor)) {
                    css.set("background-color", props.bgColor!!)
                }
                return css
            }
            )
            val customTextareaStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.color)) {
                    css.set("color", props.color!!)
                }
                if (hasStrValue(props.fontSize)) {
                    css.set("font-size", addUnit(props.fontSize!!))
                }
                css.set("height", addUnit(props.height!!))
                if (props.maxHeight != null) {
                    css.set("max-height", addUnit(props.maxHeight!!))
                }
                if (props.minHeight != null) {
                    css.set("min-height", addUnit(props.minHeight!!))
                }
                return css
            }
            )
            val textareaClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.b(""),
                    ns.theme(),
                    ns.`is`("disabled", isDisabled.value),
                    ns.m(props.border)
                )
            }
            )
            val textareaInnerClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.e("textarea"),
                    ns.`is`("__textarea--disabled", isDisabled.value),
                    ns.e("textarea--" + (props.textareaAlign ?: "left"))
                )
            }
            )
            val countClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.e("count"),
                    ns.`is`("__count--disabled", isDisabled.value)
                )
            }
            )
            val _placeholderStyle = computed(fun(): String {
                var baseColor = if (isDark.value) {
                    "#4d4d4d"
                } else {
                    "#c8c9cc"
                }
                var css = "color:" + baseColor + ";font-size:" + addUnit(props.fontSize ?: "15px") + ";"
                return css + (props.placeholderStyle ?: "")
            }
            )
            onUnmounted(fun(){
                if (timer != null) {
                    clearTimeout(timer!!)
                }
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(unref(textareaClass)), "style" to _nS(_uA(
                    unref(bgcolorStyle),
                    _ctx.customStyle
                ))), _uA(
                    _cE("textarea", _uM("modelValue" to modelValue.value, "onInput" to _uA<Any?>(fun(`$event`: UniInputEvent){
                        modelValue.value = `$event`.detail.value
                    }
                    , onInput), "inputmode" to _ctx.inputmode, "placeholder" to _ctx.placeholder, "disabled" to (unref(isDisabled) || unref(isReadonly)), "maxlength" to _ctx.maxlength, "placeholder-style" to unref(_placeholderStyle), "cursor-spacing" to _ctx.cursorSpacing, "cursor-color" to _ctx.cursorColor, "auto-focus" to _ctx.autoFocus, "focus" to _ctx.focus, "confirm-type" to _ctx.confirmType, "confirm-hold" to _ctx.confirmHold, "cursor" to _ctx.cursor, "selection-start" to _ctx.selectionStart, "selection-end" to _ctx.selectionEnd, "adjust-position" to _ctx.adjustPosition, "hold-keyboard" to _ctx.holdKeyboard, "fixed" to _ctx.fixed, "show-confirm-bar" to _ctx.showConfirmBar, "disable-default-padding" to _ctx.disableDefaultPadding, "auto-height" to _ctx.autoHeight, "class" to _nC(unref(textareaInnerClass)), "style" to _nS(_uA(
                        unref(customTextareaStyle),
                        _ctx.textareaStyle
                    )), "onFocus" to onFocus, "onBlur" to onBlur, "onKeyboardheightchange" to onKeyboardheightchange, "onChange" to onChange, "onLinechange" to onLinechange), null, 46, _uA(
                        "modelValue",
                        "onInput",
                        "inputmode",
                        "placeholder",
                        "disabled",
                        "maxlength",
                        "placeholder-style",
                        "cursor-spacing",
                        "cursor-color",
                        "auto-focus",
                        "focus",
                        "confirm-type",
                        "confirm-hold",
                        "cursor",
                        "selection-start",
                        "selection-end",
                        "adjust-position",
                        "hold-keyboard",
                        "fixed",
                        "show-confirm-bar",
                        "disable-default-padding",
                        "auto-height"
                    )),
                    if (isTrue(_ctx.showWordLimit && _ctx.maxlength >= 0)) {
                        _cE("text", _uM("key" to 0, "class" to _nC(unref(countClass)), "style" to _nS(unref(bgcolorStyle))), _tD(modelValue.value!!.length) + "/" + _tD(_ctx.maxlength), 7)
                    } else {
                        _cC("v-if", true)
                    }
                ), 6)
            }
        }
        var name = "rice-textarea"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-textarea" to _pS(_uM("position" to "relative", "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "backgroundColor" to "var(--rice-textarea-background)", "paddingTop" to 10, "paddingRight" to 10, "paddingBottom" to 10, "paddingLeft" to 10)), "rice-textarea__textarea" to _pS(_uM("textAlign" to "left", "fontSize" to "var(--rice-font-size-basic)", "color" to "var(--rice-text-color)", "width" to "100%")), "rice-textarea__textarea--disabled" to _pS(_uM("color" to "var(--rice-textarea-disabled-text-color)")), "rice-textarea__textarea--center" to _pS(_uM("textAlign" to "center")), "rice-textarea__textarea--right" to _pS(_uM("textAlign" to "right")), "rice-textarea__count" to _pS(_uM("position" to "absolute", "right" to 5, "bottom" to 2, "fontSize" to 12, "backgroundColor" to "var(--rice-textarea-background)", "color" to "var(--rice-text-color-2)", "paddingTop" to 1, "paddingRight" to 4, "paddingBottom" to 1, "paddingLeft" to 4)), "rice-textarea__count--disabled" to _pS(_uM("backgroundColor" to "var(--rice-textarea-disabled-background)", "color" to "var(--rice-textarea-disabled-text-color)")), "rice-textarea--surround" to _pS(_uM("borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "var(--rice-textarea-border-color)", "borderRightColor" to "var(--rice-textarea-border-color)", "borderBottomColor" to "var(--rice-textarea-border-color)", "borderLeftColor" to "var(--rice-textarea-border-color)")), "rice-textarea--bottom" to _pS(_uM("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "var(--rice-textarea-border-color)")), "rice-textarea--disabled" to _pS(_uM("backgroundColor" to "var(--rice-textarea-disabled-background)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("input" to null, "focus" to null, "blur" to null, "keyboardheightchange" to null, "change" to null, "linechange" to null, "update:modelValue" to null)
        var props = _nP(_uM("disabled" to _uM("type" to "Boolean", "required" to false), "readonly" to _uM("type" to "Boolean", "required" to false), "placeholder" to _uM("type" to "String", "required" to false), "placeholderStyle" to _uM("type" to "String", "required" to false), "maxlength" to _uM("type" to "Number", "required" to false, "default" to -1), "cursorSpacing" to _uM("type" to "Number", "required" to false, "default" to 0), "cursorColor" to _uM("type" to "String", "required" to false), "autoFocus" to _uM("type" to "Boolean", "required" to false, "default" to false), "focus" to _uM("type" to "Boolean", "required" to false, "default" to false), "confirmType" to _uM("type" to "String", "required" to false, "default" to "return"), "confirmHold" to _uM("type" to "Boolean", "required" to false, "default" to false), "autoHeight" to _uM("type" to "Boolean", "required" to false, "default" to false), "cursor" to _uM("type" to "Number", "required" to false, "default" to 0), "selectionStart" to _uM("type" to "Number", "required" to false, "default" to -1), "selectionEnd" to _uM("type" to "Number", "required" to false, "default" to -1), "adjustPosition" to _uM("type" to "Boolean", "required" to false, "default" to true), "inputmode" to _uM("type" to "String", "required" to false), "holdKeyboard" to _uM("type" to "Boolean", "required" to false, "default" to false), "fixed" to _uM("type" to "Boolean", "required" to false), "showConfirmBar" to _uM("type" to "Boolean", "required" to false), "disableDefaultPadding" to _uM("type" to "Boolean", "required" to false), "height" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false, "default" to "90px"), "minHeight" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "maxHeight" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "color" to _uM("type" to "String", "required" to false), "fontSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "showWordLimit" to _uM("type" to "Boolean", "required" to false, "default" to false), "border" to _uM("type" to "String", "required" to false, "default" to "surround"), "bgColor" to _uM("type" to "String", "required" to false), "textareaAlign" to _uM("type" to "String", "required" to false), "textareaStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        ), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        ), "modelValue" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "disabled",
            "readonly",
            "maxlength",
            "cursorSpacing",
            "autoFocus",
            "focus",
            "confirmType",
            "confirmHold",
            "autoHeight",
            "cursor",
            "selectionStart",
            "selectionEnd",
            "adjustPosition",
            "holdKeyboard",
            "fixed",
            "showConfirmBar",
            "disableDefaultPadding",
            "height",
            "showWordLimit",
            "border",
            "textareaStyle",
            "customStyle",
            "modelValue"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
