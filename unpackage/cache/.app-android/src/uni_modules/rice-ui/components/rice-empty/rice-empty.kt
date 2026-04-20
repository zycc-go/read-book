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
open class GenUniModulesRiceUiComponentsRiceEmptyRiceEmpty : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var image: String by `$props`
    open var width: Any? by `$props`
    open var height: Any? by `$props`
    open var text: String? by `$props`
    open var textColor: String? by `$props`
    open var textSize: Any? by `$props`
    open var marginTop: Any? by `$props`
    open var customStyle: UTSJSONObject by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceEmptyRiceEmpty) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceEmptyRiceEmpty
            val _cache = __ins.renderCache
            val ns = useNamespace("empty")
            val props = __props
            val imageSrc = computed(fun(): String {
                if (props.image == "empty") {
                    return ""
                } else if (props.image == "error") {
                    return ""
                } else if (props.image == "network") {
                    return ""
                } else if (props.image == "search") {
                    return ""
                }
                return props.image
            }
            )
            val emptyStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.marginTop != null) {
                    css.set("marginTop", addUnit(props.marginTop!!))
                }
                return css
            }
            )
            val imageStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.width != null) {
                    css.set("width", addUnit(props.width!!))
                }
                if (props.height != null) {
                    css.set("height", addUnit(props.height!!))
                }
                return css
            }
            )
            val textStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.textSize != null) {
                    css.set("text-size", addUnit(props.textSize!!))
                }
                if (props.textColor != null) {
                    css.set("color", props.textColor!!)
                }
                return css
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    unref(ns).b(""),
                    unref(ns).theme()
                )), "style" to _nS(_uA(
                    unref(emptyStyle),
                    _ctx.customStyle
                ))), _uA(
                    renderSlot(_ctx.`$slots`, "image", _uO(), fun(): UTSArray<Any> {
                        return _uA(
                            _cE("image", _uM("class" to "rice-empty__image", "src" to unref(imageSrc), "style" to _nS(unref(imageStyle))), null, 12, _uA(
                                "src"
                            ))
                        )
                    }
                    ),
                    renderSlot(_ctx.`$slots`, "text", _uO(), fun(): UTSArray<Any> {
                        return _uA(
                            if (isTrue(unref(hasStrValue)(_ctx.text))) {
                                _cE("text", _uM("key" to 0, "class" to "rice-empty__text", "style" to _nS(unref(textStyle))), _tD(_ctx.text), 5)
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    ),
                    renderSlot(_ctx.`$slots`, "default")
                ), 6)
            }
        }
        var name = "rice-empty"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-empty" to _pS(_uM("flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "boxSizing" to "border-box", "paddingTop" to "var(--rice-padding-md)", "paddingRight" to 0, "paddingBottom" to "var(--rice-padding-md)", "paddingLeft" to 0)), "rice-empty__image" to _pS(_uM("height" to 160, "width" to 160)), "rice-empty__text" to _pS(_uM("fontSize" to "var(--rice-font-size-sm)", "color" to "var(--rice-text-color-2)", "marginTop" to "var(--rice-padding-md)", "paddingTop" to 0, "paddingRight" to "var(--rice-padding-md)", "paddingBottom" to 0, "paddingLeft" to "var(--rice-padding-md)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("image" to _uM("type" to "String", "required" to false, "default" to "empty"), "width" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "height" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "text" to _uM("type" to "String", "required" to false), "textColor" to _uM("type" to "String", "required" to false), "textSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "marginTop" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        )))
        var propsNeedCastKeys = _uA(
            "image",
            "customStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
