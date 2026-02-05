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
open class GenUniModulesRiceUiComponentsRiceIconRiceIcon : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var name: String by `$props`
    open var size: Any? by `$props`
    open var color: String? by `$props`
    open var bold: Boolean? by `$props`
    open var fontFamily: String? by `$props`
    open var stop: Boolean by `$props`
    open var customStyle: UTSJSONObject by `$props`
    open var customClass: String? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceIconRiceIcon) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceIconRiceIcon
            val _cache = __ins.renderCache
            val ns = useNamespace("icon")
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val isBase64 = fun(): Boolean {
                return props.name.indexOf("data:") > -1 && props.name.indexOf("base64") > -1
            }
            val isImage = computed<Boolean>(fun(): Boolean {
                return props.name.includes("/") || isBase64()
            }
            )
            val iconCode = computed(fun(): String {
                if (props.fontFamily != null) {
                    return String.fromCharCode(parseInt(props.name, 16))
                }
                return fontData.find(fun(v): Boolean {
                    return v.name == props.name
                }
                )?.code ?: ""
            }
            )
            val iconClick = fun(e: UniPointerEvent){
                if (props.stop == true) {
                    e.stopPropagation()
                }
                emit("click", e)
            }
            val iconStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.size != null) {
                    css.set("font-size", addUnit(props.size!!))
                }
                if (hasStrValue(props.color)) {
                    css.set("color", props.color!!)
                }
                if (props.fontFamily != null) {
                    css.set("font-family", props.fontFamily!!)
                }
                return css
            }
            )
            val imageStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.size)) {
                    val size = addUnit(props.size!!)
                    css.set("height", addUnit(size))
                    css.set("width", addUnit(size))
                }
                return css
            }
            )
            val iconClass = computed(fun(): UTSArray<String> {
                val basic = _uA(
                    ns.theme(),
                    ns.`is`("bold", props.bold ?: false),
                    props.customClass ?: ""
                )
                return basic
            }
            )
            return fun(): Any? {
                return if (isTrue(!unref(isImage))) {
                    _cE("text", _uM("key" to 0, "class" to _nC(_uA(
                        "rice-icon",
                        unref(iconClass)
                    )), "style" to _nS(_uA(
                        unref(iconStyle),
                        _ctx.customStyle
                    )), "onClick" to iconClick), _uA(
                        renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                            return _uA(
                                _tD(unref(iconCode))
                            )
                        })
                    ), 6)
                } else {
                    _cE("image", _uM("key" to 1, "src" to _ctx.name, "class" to "rice-icon__image", "style" to _nS(_uA(
                        unref(imageStyle),
                        _ctx.customStyle
                    )), "onClick" to iconClick), null, 12, _uA(
                        "src"
                    ))
                }
            }
        }
        var name = "rice-icon"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-icon" to _pS(_uM("color" to "var(--rice-text-color-2)", "fontFamily" to "riceIcon")), "rice-icon--bold" to _pS(_uM("fontWeight" to "bold")), "rice-icon__image" to _pS(_uM("height" to 16, "width" to 16)), "@FONT-FACE" to _uM("0" to _uM("fontFamily" to "riceIcon", "src" to "url(\"/uni_modules/rice-ui/static/font/riceIcons.ttf\")")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null)
        var props = _nP(_uM("name" to _uM("type" to "String", "required" to false, "default" to ""), "size" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "color" to _uM("type" to "String", "required" to false), "bold" to _uM("type" to "Boolean", "required" to false), "fontFamily" to _uM("type" to "String", "required" to false), "stop" to _uM("type" to "Boolean", "required" to false, "default" to false), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "customClass" to _uM("type" to "String", "required" to false)))
        var propsNeedCastKeys = _uA(
            "name",
            "bold",
            "stop",
            "customStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
