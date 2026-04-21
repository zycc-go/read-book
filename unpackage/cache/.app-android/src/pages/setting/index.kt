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
import io.dcloud.uniapp.extapi.redirectTo as uni_redirectTo
import io.dcloud.uniapp.extapi.setAppTheme as uni_setAppTheme
import io.dcloud.uniapp.extapi.showToast as uni_showToast
import io.dcloud.uniapp.extapi.switchTab as uni_switchTab
open class GenPagesSettingIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesSettingIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesSettingIndex
            val _cache = __ins.renderCache
            val isDark = ref<Boolean>(!state.isFollowSystem && state.appTheme == "dark")
            val isFollowSystem = ref<Boolean>(state.isFollowSystem)
            val onChangeIsDark = fun(value: Boolean){
                isDark.value = value
                var themeReal: String = "light"
                if (value) {
                    isFollowSystem.value = false
                    setIsFollowSystem(false)
                    themeReal = "dark"
                }
                setTheme(themeReal)
                setAppTheme(themeReal)
                uni_setAppTheme(SetAppThemeOptions(theme = themeReal))
            }
            val onChangeIsFollowSystem = fun(value: Boolean){
                isFollowSystem.value = value
                var themeReal: String = "light"
                if (value) {
                    isDark.value = false
                    themeReal = state.osTheme
                }
                setTheme(themeReal)
                setAppTheme(themeReal)
                setIsFollowSystem(value)
                uni_setAppTheme(SetAppThemeOptions(theme = themeReal))
            }
            val onClickLeft = fun(){
                if (state.uniPlatform === "app") {
                    uni_switchTab(SwitchTabOptions(url = "/pages/mine/index"))
                } else {
                    uni_redirectTo(RedirectToOptions(url = "/pages/mine/index"))
                }
            }
            val onClickSwitch = fun(){
                if (state.uniPlatform !== "app") {
                    uni_showToast(ShowToastOptions(title = "只有app才能用", icon = "error"))
                }
            }
            return fun(): Any? {
                val _component_rice_navbar = resolveEasyComponent("rice-navbar", GenUniModulesRiceUiComponentsRiceNavbarRiceNavbarClass)
                val _component_rice_switch = resolveEasyComponent("rice-switch", GenUniModulesRiceUiComponentsRiceSwitchRiceSwitchClass)
                val _component_rice_cell = resolveEasyComponent("rice-cell", GenUniModulesRiceUiComponentsRiceCellRiceCellClass)
                val _component_rice_cell_group = resolveEasyComponent("rice-cell-group", GenUniModulesRiceUiComponentsRiceCellGroupRiceCellGroupClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "rice-theme-" + unref(state).appTheme,
                    "page"
                ))), _uA(
                    _cV(_component_rice_navbar, _uM("height" to unref(state).navbarHeight, "title" to "设置", "onClickLeft" to onClickLeft), null, 8, _uA(
                        "height"
                    )),
                    _cE("view", _uM("class" to "card"), _uA(
                        _cV(_component_rice_cell_group, _uM("radius" to "8px"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_rice_cell, _uM("title" to "深色模式"), _uM("rightIcon" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_rice_switch, _uM("modelValue" to unref(isDark), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            trySetRefValue(isDark, `$event`)
                                        }
                                        , "onChange" to onChangeIsDark), null, 8, _uA(
                                            "modelValue"
                                        ))
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_rice_cell, _uM("title" to "跟随系统设置", "label" to "开启后，自动跟随系统外观模式设置"), _uM("rightIcon" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_rice_switch, _uM("modelValue" to unref(isFollowSystem), "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            trySetRefValue(isFollowSystem, `$event`)
                                        }
                                        , "onChange" to onChangeIsFollowSystem, "disabled" to (unref(state).uniPlatform !== "app"), "onClick" to onClickSwitch), null, 8, _uA(
                                            "modelValue",
                                            "disabled"
                                        ))
                                    )
                                }
                                ), "_" to 1))
                            )
                        }
                        ), "_" to 1))
                    ))
                ), 2)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--rice-navbar-background)", "height" to "100%", "width" to "100%")), "card" to _pS(_uM("paddingTop" to 12, "paddingRight" to 16, "paddingBottom" to 12, "paddingLeft" to 16)), "rice-icon" to _uM(".card " to _uM("display" to "flex", "alignItems" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
