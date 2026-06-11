import { state, setAppTheme, setIsFollowSystem } from '@/store/index.uts'
	import MyNavbar from '@/componnets/MyNavbar.uvue';
	import MyCell from '@/componnets/MyCell.uvue';
	import MyCellGroup from '@/componnets/MyCellGroup.uvue';

	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const isDark = ref<boolean>(!state.isFollowSystem && state.appTheme == 'dark')
	const isFollowSystem = ref<boolean>(state.isFollowSystem)

	const onChangeIsDark = (event: UniSwitchChangeEvent) => {
		isDark.value = event.detail.value
		let themeReal : "light" | "dark" = 'light'
		if (isDark.value) {
			isFollowSystem.value = false
			setIsFollowSystem(false)
			themeReal = 'dark';
		}
		setAppTheme(themeReal)
		uni.setAppTheme({ theme: themeReal })
	}

	const onChangeIsFollowSystem = (event: UniSwitchChangeEvent) => {
		isFollowSystem.value = event.detail.value
		let themeReal : "light" | "dark" = 'light'
		if (isFollowSystem.value) {
			isDark.value = false
			themeReal = state.osTheme
		}
		setAppTheme(themeReal)
		setIsFollowSystem(isFollowSystem.value)
		uni.setAppTheme({ theme: themeReal })
	}

	const onClickLeft = () => {
		if (state.uniPlatform === 'app') {
			uni.switchTab({ url: '/pages/mine/index' })
		} else {
			uni.redirectTo({ url: '/pages/mine/index' })
		}
	}

	const onClickSwitch = () => {
		if (state.uniPlatform !== 'app') {
			uni.showToast({ title: '只有app才能用', icon: 'error' })
		}
	}

return (): any | null => {

const _component_switch = resolveComponent("switch")

  return _cE("view", _uM({
    class: _nC([`theme-${unref(state).appTheme}`, "page"])
  }), [
    _cV(unref(MyNavbar), _uM({
      leftArrow: "",
      title: "设置"
    })),
    _cV(unref(MyCellGroup), null, _uM({
      default: withSlotCtx((): any[] => [
        _cV(unref(MyCell), _uM({ title: "深色模式" }), _uM({
          rightIcon: withSlotCtx((): any[] => [
            _cV(_component_switch, _uM({
              checked: unref(isDark),
              onChange: onChangeIsDark
            }), null, 8 /* PROPS */, ["checked"])
          ]),
          _: 1 /* STABLE */
        })),
        _cV(unref(MyCell), _uM({
          title: "跟随系统设置",
          label: "开启后，自动跟随系统外观模式设置"
        }), _uM({
          rightIcon: withSlotCtx((): any[] => [
            _cV(_component_switch, _uM({
              checked: unref(isFollowSystem),
              onChange: onChangeIsFollowSystem,
              disabled: unref(state).uniPlatform !== 'app',
              onClick: onClickSwitch
            }), null, 8 /* PROPS */, ["checked", "disabled"])
          ]),
          _: 1 /* STABLE */
        }))
      ]),
      _: 1 /* STABLE */
    }))
  ], 2 /* CLASS */)
}
}

})
export default __sfc__
const GenPagesSettingIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--navbar-background)"], ["height", "100%"], ["width", "100%"]]))], ["card", _pS(_uM([["paddingTop", 12], ["paddingRight", 16], ["paddingBottom", 12], ["paddingLeft", 16]]))]])]
