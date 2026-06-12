import { state, setAppTheme, setIsFollowSystem } from '@/store/index.uts'
	import MyNavbar from '@/componnets/MyNavbar.uvue';
	import MyCell from '@/componnets/MyCell.uvue';
	import MyCellGroup from '@/componnets/MyCellGroup.uvue';
	import MySwitch from '@/componnets/MySwitch.uvue';

	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const style = computed(() => {
		return {
			paddingTop: state.statusBarHeight + state.navbarHeight + 'px',
			paddingBottom: state.safeAreaInsetsHeight + 'px',
		};
	})

	const isDark = ref<boolean>(!state.isFollowSystem && state.appTheme == 'dark')
	const isFollowSystem = ref<boolean>(state.isFollowSystem)

	const onChangeIsDark = (value : boolean) => {
		isDark.value = value
		let themeReal : "light" | "dark" = 'light'
		if (isDark.value) {
			isFollowSystem.value = false
			setIsFollowSystem(false)
			themeReal = 'dark';
		}
		setAppTheme(themeReal)
		uni.setAppTheme({ theme: themeReal })
	}

	const onChangeIsFollowSystem = (value : boolean) => {
		isFollowSystem.value = value
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

return (): any | null => {

  return _cE("view", _uM({
    class: _nC([`theme-${unref(state).appTheme}`, 'page']),
    style: _nS(unref(style))
  }), [
    _cV(unref(MyNavbar), _uM({
      leftArrow: "",
      title: "设置"
    })),
    _cV(unref(MyCellGroup), _uM({ inset: true }), _uM({
      default: withSlotCtx((): any[] => [
        _cV(unref(MyCell), _uM({ title: "深色模式" }), _uM({
          rightIcon: withSlotCtx((): any[] => [
            _cV(unref(MySwitch), _uM({
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
            _cV(unref(MySwitch), _uM({
              checked: unref(isFollowSystem),
              disabled: unref(state).uniPlatform !== 'app',
              onChange: onChangeIsFollowSystem
            }), null, 8 /* PROPS */, ["checked", "disabled"])
          ]),
          _: 1 /* STABLE */
        }))
      ]),
      _: 1 /* STABLE */
    }))
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
const GenPagesSettingIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--navbar-background)"], ["height", "100%"], ["width", "100%"]]))], ["card", _pS(_uM([["paddingTop", 12], ["paddingRight", 16], ["paddingBottom", 12], ["paddingLeft", 16]]))]])]
