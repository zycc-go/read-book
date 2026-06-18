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
import io.dcloud.uniapp.extapi.setAppTheme as uni_setAppTheme
open class GenPagesSettingIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesSettingIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesSettingIndex
            val _cache = __ins.renderCache
            val style = computed(fun(): UTSJSONObject {
                return _uO("paddingTop" to (state.statusBarHeight + state.navbarHeight + "px"), "paddingBottom" to (state.safeAreaInsetsHeight + "px"))
            }
            )
            val isDark = ref<Boolean>(!state.isFollowSystem && state.appTheme == "dark")
            val isFollowSystem = ref<Boolean>(state.isFollowSystem)
            val onChangeIsDark = fun(value: Boolean){
                isDark.value = value
                var themeReal: String = "light"
                if (isDark.value) {
                    isFollowSystem.value = false
                    setIsFollowSystem(false)
                    themeReal = "dark"
                }
                setAppTheme(themeReal)
                uni_setAppTheme(SetAppThemeOptions(theme = themeReal))
            }
            val onChangeIsFollowSystem = fun(value: Boolean){
                isFollowSystem.value = value
                var themeReal: String = "light"
                if (isFollowSystem.value) {
                    isDark.value = false
                    themeReal = state.osTheme
                }
                setAppTheme(themeReal)
                setIsFollowSystem(isFollowSystem.value)
                uni_setAppTheme(SetAppThemeOptions(theme = themeReal))
            }
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "theme-" + unref(state).appTheme,
                    "page"
                )), "style" to _nS(unref(style))), _uA(
                    _cV(unref(GenComponnetsMyNavbarIndexClass), _uM("leftArrow" to "", "title" to "设置")),
                    _cV(unref(GenComponnetsMyCellGroupIndexClass), _uM("inset" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cV(unref(GenComponnetsMyCellIndexClass), _uM("title" to "深色模式"), _uM("rightIcon" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(unref(GenComponnetsMySwitchIndexClass), _uM("checked" to unref(isDark), "onChange" to onChangeIsDark), null, 8, _uA(
                                        "checked"
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(unref(GenComponnetsMyCellIndexClass), _uM("title" to "跟随系统设置", "label" to "开启后，自动跟随系统外观模式设置"), _uM("rightIcon" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(unref(GenComponnetsMySwitchIndexClass), _uM("checked" to unref(isFollowSystem), "disabled" to (unref(state).uniPlatform !== "app"), "onChange" to onChangeIsFollowSystem), null, 8, _uA(
                                        "checked",
                                        "disabled"
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )
                    }
                    ), "_" to 1))
                ), 6)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--navbar-background)", "height" to "100%", "width" to "100%")), "card" to _pS(_uM("paddingTop" to 12, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
