@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
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
open class GenUniModulesRiceUiComponentsRiceSearchRiceSearch : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var label: String? by `$props`
    open var shape: String by `$props`
    open var bgColor: String? by `$props`
    open var inputColor: String? by `$props`
    open var fontSize: Any? by `$props`
    open var color: String? by `$props`
    open var height: Any? by `$props`
    open var maxlength: Number by `$props`
    open var holdKeyboard: Boolean by `$props`
    open var placeholder: String by `$props`
    open var placeholderStyle: String? by `$props`
    open var focus: Boolean by `$props`
    open var clearable: Boolean by `$props`
    open var clearIcon: String by `$props`
    open var clearTrigger: String by `$props`
    open var showAction: Boolean by `$props`
    open var actionText: String by `$props`
    open var actionSize: Any? by `$props`
    open var actionColor: String? by `$props`
    open var disabled: Boolean by `$props`
    open var inputAlign: String by `$props`
    open var leftIcon: String by `$props`
    open var rightIcon: String? by `$props`
    open var leftIconSize: Any by `$props`
    open var leftIconColor: String? by `$props`
    open var rightIconSize: Any by `$props`
    open var rightIconColor: String? by `$props`
    open var customStyle: UTSJSONObject by `$props`
    open var modelValue: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceSearchRiceSearch) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceSearchRiceSearch
            val _cache = __ins.renderCache
            val ns = useNamespace("search")
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val modelValue = useModel<String>(__ins.props, "modelValue")
            val isFocus = ref(false)
            val isShowClearable = computed<Boolean>(fun(): Boolean {
                if (props.disabled) {
                    return false
                }
                val shouldTrigger = if (props.clearTrigger == "focus") {
                    isFocus.value
                } else {
                    true
                }
                return props.clearable && modelValue.value != "" && shouldTrigger
            }
            )
            val onClear = fun(){
                if (props.disabled) {
                    return
                }
                modelValue.value = ""
                emit("clear")
            }
            val handleClick = fun(e: UniPointerEvent){
                emit("clickInput", e)
            }
            val onInput = fun(e: UniInputEvent){
                emit("input", e.detail.value)
            }
            val onFocus = fun(e: UniInputFocusEvent){
                isFocus.value = true
                emit("focus", e)
            }
            var timer: Number? = null
            val onBlur = fun(e: UniInputBlurEvent){
                timer = setTimeout(fun(){
                    isFocus.value = false
                    emit("blur", e)
                }
                , 100)
            }
            val onConfirm = fun(e: UniInputConfirmEvent){
                emit("search", e.detail.value)
            }
            val onKeyboardheightchange = fun(e: UniInputKeyboardHeightChangeEvent){
                emit("keyboardheightchange", e)
            }
            val clickLeftIcon = fun(){
                emit("clickLeftIcon", modelValue.value)
            }
            val clickRightIcon = fun(){
                emit("clickRightIcon", modelValue.value)
            }
            val clickAction = fun(){
                emit("clickAction", modelValue.value)
            }
            val searchStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.bgColor)) {
                    css.set("background-color", props.bgColor!!)
                }
                return css
            }
            )
            val wrapperStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.height != null) {
                    css.set("height", addUnit(props.height!!))
                }
                if (hasStrValue(props.inputColor)) {
                    css.set("background-color", props.inputColor!!)
                }
                return css
            }
            )
            val inputStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.fontSize != null) {
                    css.set("font-size", addUnit(props.fontSize!!))
                }
                if (hasStrValue(props.color)) {
                    css.set("color", props.color!!)
                }
                return css
            }
            )
            val actionStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.actionSize != null) {
                    css.set("font-size", addUnit(props.actionSize!!))
                }
                if (hasStrValue(props.actionColor)) {
                    css.set("color", props.actionColor!!)
                }
                return css
            }
            )
            val inputClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.e("wrapper__input"),
                    ns.e("wrapper__input--" + props.inputAlign)
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
            val clearIconStyle = computed(fun(): UTSJSONObject {
                return object : UTSJSONObject() {
                    var paddingLeft = "6px"
                }
            }
            )
            val searchClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.b(""),
                    ns.theme()
                )
            }
            )
            val wrapperClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.e("wrapper"),
                    ns.e("wrapper--" + props.shape)
                )
            }
            )
            onUnmounted(fun(){
                if (timer != null) {
                    clearTimeout(timer!!)
                }
            }
            )
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                return _cE("view", _uM("class" to _nC(unref(searchClass)), "style" to _nS(_uA(
                    unref(searchStyle),
                    _ctx.customStyle
                ))), _uA(
                    renderSlot(_ctx.`$slots`, "left"),
                    _cE("view", _uM("class" to _nC(unref(wrapperClass)), "style" to _nS(unref(wrapperStyle))), _uA(
                        if (isTrue(_ctx.`$slots`["label"] != null || unref(hasStrValue)(_ctx.label))) {
                            renderSlot(_ctx.`$slots`, "label", _uM("key" to 0), fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("text", _uM("class" to "rice-search__label"), _tD(_ctx.label), 1)
                                )
                            })
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(_ctx.`$slots`["leftIcon"] != null || unref(hasStrValue)(_ctx.leftIcon))) {
                            renderSlot(_ctx.`$slots`, "leftIcon", _uM("key" to 1), fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_rice_icon, _uM("name" to _ctx.leftIcon, "size" to _ctx.leftIconSize, "color" to _ctx.leftIconColor, "onClick" to clickLeftIcon), null, 8, _uA(
                                        "name",
                                        "size",
                                        "color"
                                    ))
                                )
                            })
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cE("input", _uM("modelValue" to modelValue.value, "onInput" to _uA<Any?>(fun(`$event`: UniInputEvent){
                            modelValue.value = `$event`.detail.value
                        }
                        , onInput), "type" to "search", "inputmode" to "search", "maxlength" to _ctx.maxlength, "confirm-type" to "search", "focus" to _ctx.focus, "disabled" to _ctx.disabled, "holdKeyboard" to _ctx.holdKeyboard, "placeholder" to _ctx.placeholder, "placeholder-style" to unref(_placeholderStyle), "class" to _nC(unref(inputClass)), "style" to _nS(unref(inputStyle)), "onFocus" to onFocus, "onBlur" to onBlur, "onConfirm" to onConfirm, "onKeyboardheightchange" to onKeyboardheightchange, "onClick" to handleClick), null, 46, _uA(
                            "modelValue",
                            "onInput",
                            "maxlength",
                            "focus",
                            "disabled",
                            "holdKeyboard",
                            "placeholder",
                            "placeholder-style"
                        )),
                        if (isTrue(_ctx.`$slots`["rightIcon"] != null || unref(hasStrValue)(_ctx.rightIcon))) {
                            renderSlot(_ctx.`$slots`, "rightIcon", _uM("key" to 2), fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_rice_icon, _uM("name" to _ctx.rightIcon, "size" to _ctx.rightIconSize, "color" to _ctx.rightIconColor, "onClick" to clickRightIcon), null, 8, _uA(
                                        "name",
                                        "size",
                                        "color"
                                    ))
                                )
                            })
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (isTrue(unref(isShowClearable))) {
                            _cV(_component_rice_icon, _uM("key" to 3, "name" to _ctx.clearIcon, "size" to "17px", "custom-style" to unref(clearIconStyle), "onClick" to onClear), null, 8, _uA(
                                "name",
                                "custom-style"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ), 6),
                    if (isTrue(_ctx.showAction)) {
                        renderSlot(_ctx.`$slots`, "action", _uM("key" to 0), fun(): UTSArray<Any> {
                            return _uA(
                                _cE("text", _uM("class" to "rice-search__action", "style" to _nS(unref(actionStyle)), "onClick" to clickAction), _tD(_ctx.actionText), 5)
                            )
                        })
                    } else {
                        _cC("v-if", true)
                    }
                ), 6)
            }
        }
        var name = "rice-search"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-search" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "var(--rice-search-background)", "paddingTop" to 10, "paddingRight" to 12, "paddingBottom" to 10, "paddingLeft" to 12)), "rice-search__label" to _pS(_uM("paddingRight" to 5, "fontSize" to "var(--rice-font-size-sm)", "color" to "var(--rice-text-color)")), "rice-search__wrapper" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "var(--rice-search-input-background)", "height" to 36, "paddingTop" to 0, "paddingRight" to 10, "paddingBottom" to 0, "paddingLeft" to 10, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4)), "rice-search__wrapper__input" to _pS(_uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "paddingTop" to 0, "paddingRight" to 8, "paddingBottom" to 0, "paddingLeft" to 8, "fontSize" to "var(--rice-font-size-basic)", "color" to "var(--rice-text-color)", "height" to "100%", "textAlign" to "left")), "rice-search__wrapper__input--center" to _pS(_uM("textAlign" to "center")), "rice-search__wrapper__input--right" to _pS(_uM("textAlign" to "right")), "rice-search__wrapper--round" to _pS(_uM("borderTopLeftRadius" to 999, "borderTopRightRadius" to 999, "borderBottomRightRadius" to 999, "borderBottomLeftRadius" to 999)), "rice-search__action" to _pS(_uM("paddingLeft" to 10, "fontSize" to "var(--rice-font-size-sm)", "color" to "var(--rice-text-color)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("input" to null, "search" to null, "focus" to null, "blur" to null, "keyboardheightchange" to null, "clickInput" to null, "clickLeftIcon" to null, "clickRightIcon" to null, "clickAction" to null, "clear" to null, "update:modelValue" to null)
        var props = _nP(_uM("label" to _uM("type" to "String", "required" to false), "shape" to _uM("type" to "String", "required" to false, "default" to "square"), "bgColor" to _uM("type" to "String", "required" to false), "inputColor" to _uM("type" to "String", "required" to false), "fontSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "color" to _uM("type" to "String", "required" to false), "height" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "maxlength" to _uM("type" to "Number", "required" to false, "default" to -1), "holdKeyboard" to _uM("type" to "Boolean", "required" to false, "default" to false), "placeholder" to _uM("type" to "String", "required" to false, "default" to "请输入搜索关键字"), "placeholderStyle" to _uM("type" to "String", "required" to false), "focus" to _uM("type" to "Boolean", "required" to false, "default" to false), "clearable" to _uM("type" to "Boolean", "required" to false, "default" to true), "clearIcon" to _uM("type" to "String", "required" to false, "default" to "clear"), "clearTrigger" to _uM("type" to "String", "required" to false, "default" to "focus"), "showAction" to _uM("type" to "Boolean", "required" to false, "default" to false), "actionText" to _uM("type" to "String", "required" to false, "default" to "搜索"), "actionSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "actionColor" to _uM("type" to "String", "required" to false), "disabled" to _uM("type" to "Boolean", "required" to false, "default" to false), "inputAlign" to _uM("type" to "String", "required" to false, "default" to "left"), "leftIcon" to _uM("type" to "String", "required" to false, "default" to "search"), "rightIcon" to _uM("type" to "String", "required" to false), "leftIconSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false, "default" to "16px"), "leftIconColor" to _uM("type" to "String", "required" to false), "rightIconSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false, "default" to "16px"), "rightIconColor" to _uM("type" to "String", "required" to false), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "shape",
            "maxlength",
            "holdKeyboard",
            "placeholder",
            "focus",
            "clearable",
            "clearIcon",
            "clearTrigger",
            "showAction",
            "actionText",
            "disabled",
            "inputAlign",
            "leftIcon",
            "leftIconSize",
            "rightIconSize",
            "customStyle",
            "modelValue"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
