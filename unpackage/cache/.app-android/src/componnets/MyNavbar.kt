@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI194B5B1
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
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
open class GenComponnetsMyNavbar : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var title: String? by `$props`
    open var leftArrow: Boolean? by `$props`
    open var height: Number? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponnetsMyNavbar) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponnetsMyNavbar
            val _cache = __ins.renderCache
            val props = __props
            val leftArrow = computed(fun(): Boolean {
                return if (_uA(
                    null,
                    true,
                    ""
                ).includes(props.leftArrow)) {
                    true
                } else {
                    false
                }
            }
            )
            val navbarHeight = computed(fun(): String {
                return (if (UTSAndroid.`typeof`(props.height) == "number") {
                    props.height!!
                } else {
                    state.navbarHeight
                }
                ) + "px"
            }
            )
            val statusBarHeight = computed(fun(): String {
                return state.statusBarHeight + "px"
            }
            )
            val onToBack = fun(){
                uni_navigateBack(null)
            }
            return fun(): Any? {
                return _cE("view", _uM("class" to "navbar-status"), _uA(
                    _cE("view", _uM("style" to _nS(_uM("height" to unref(statusBarHeight)))), null, 4),
                    _cE("view", _uM("class" to "my-navbar", "style" to _nS(_uM("height" to unref(navbarHeight)))), _uA(
                        _cE("view", _uM("class" to "my-navbar-left", "onClick" to onToBack), _uA(
                            renderSlot(_ctx.`$slots`, "left"),
                            if (isTrue(unref(leftArrow))) {
                                _cE("text", _uM("key" to 0, "class" to "icon nav-icon"), _tD("\ue668"))
                            } else {
                                _cC("v-if", true)
                            }
                        )),
                        _cE("text", _uM("class" to "my-navbar-title"), _tD(props.title), 1),
                        _cE("view", _uM("class" to "my-navbar-right"), _uA(
                            renderSlot(_ctx.`$slots`, "right")
                        ))
                    ), 4)
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("my-navbar" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "space-between", "position" to "relative")), "my-navbar-title" to _uM(".my-navbar " to _uM("position" to "absolute", "top" to "50%", "left" to "50%", "transform" to "translate(-50%, -50%)", "color" to "var(--text-color1)")), "my-navbar-right" to _uM(".my-navbar " to _uM("overflow" to "visible")), "nav-icon" to _uM(".my-navbar " to _uM("fontSize" to 24, "marginLeft" to 8)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("title" to _uM("type" to "String", "required" to false), "leftArrow" to _uM("type" to "Boolean", "required" to false), "height" to _uM("type" to "Number", "required" to false)))
        var propsNeedCastKeys = _uA(
            "leftArrow"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
