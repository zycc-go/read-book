import _easycom_uni_fab_button from '@/uni_modules/uni-fab-button/components/uni-fab-button/uni-fab-button.uvue'
import MyAvatar from '@/componnets/MyAvatar/index.uvue'
	import ItemContent from './item-content.uvue'
	import ItemAichat from './item-aichat.uvue'
	import { state } from '@/store/index.uts'
	import { discussListFun, type DiscussItem } from '@/data/discuss'


	type BadgeItem = { __$originalPosition?: UTSSourceMapPosition<"BadgeItem", "pages/discuss/index.uvue", 31, 7>;
		name : string;
		type ?: string;
		isDot ?: boolean;
		dotNum ?: number;
	}

	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const listBadge = ref<BadgeItem[]>([
		{ name: '推荐', type: '1', isDot: true },
		{ name: '关注', type: '2', dotNum: 10 },
		{ name: '我的收藏', type: '3', dotNum: 999 },
		{ name: 'AI' }])

	const activeTab = ref<number>(0)

	const onClickTab = (item : BadgeItem, index : number) => {
		console.log('onClickTab', " at pages/discuss/index.uvue:47");
		activeTab.value = index
	}

	const onChangeSwiper = (event : UniSwiperChangeEvent) => {
		console.log('onChangeSwiper', " at pages/discuss/index.uvue:52");
		activeTab.value = event.detail.current
	}

	const onToPageIssue = () => {
		uni.navigateTo({
			url: `/pages/discuss-issue/index`
		})
	}

	onMounted(() => {
		// onClickTab(listBadge.value[0], 0)
		// listBadge.value[0].renderNum = 2
	})

return (): any | null => {

const _component_uni_fab_button = resolveEasyComponent("uni-fab-button",_easycom_uni_fab_button)

  return _cE("view", _uM({
    class: _nC([`theme-${unref(state).appTheme}`, 'page']),
    style: _nS(_uM({ paddingTop:`${unref(state).statusBarHeight}px`}))
  }), [
    _cE("view", _uM({ class: "tabs" }), [
      _cE(Fragment, null, RenderHelpers.renderList(unref(listBadge), (item, index, __index, _cached): any => {
        return _cE("view", _uM({
          class: "tab",
          key: item.name,
          onClick: () => {onClickTab(item, index)}
        }), [
          _cE("text", _uM({
            class: _nC(_uM({ 'item-text': true, 'item-text-active': unref(activeTab) === index }))
          }), _tD(item.name), 3 /* TEXT, CLASS */),
          unref(activeTab) === index
            ? _cE("view", _uM({
                key: 0,
                class: "tab-indicator"
              }))
            : _cC("v-if", true)
        ], 8 /* PROPS */, ["onClick"])
      }), 128 /* KEYED_FRAGMENT */)
    ]),
    _cE("swiper", _uM({
      style: _nS(_uM({"flex":"1"})),
      current: unref(activeTab),
      onChange: onChangeSwiper
    }), [
      _cE(Fragment, null, RenderHelpers.renderList(unref(listBadge).slice(0,3), (item, index, __index, _cached): any => {
        return _cE("swiper-item", _uM({
          key: item.name
        }), [
          _cV(unref(ItemContent), _uM({
            currentIndex: unref(activeTab),
            tabIndex: index,
            type: item.type
          }), null, 8 /* PROPS */, ["currentIndex", "tabIndex", "type"])
        ])
      }), 128 /* KEYED_FRAGMENT */),
      _cE("swiper-item", null, [
        _cV(unref(ItemAichat))
      ])
    ], 44 /* STYLE, PROPS, NEED_HYDRATION */, ["current"]),
    unref(activeTab) < 3
      ? _cV(_component_uni_fab_button, _uM({
          key: 0,
          class: "fab-btn",
          onClick: onToPageIssue
        }))
      : _cC("v-if", true)
  ], 6 /* CLASS, STYLE */)
}
}

})
export default __sfc__
const GenPagesDiscussIndexStyles = [_uM([["page", _pS(_uM([["backgroundColor", "var(--navbar-background)"], ["height", "100%"], ["width", "100%"]]))], ["tabs", _pS(_uM([["height", 44], ["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["paddingTop", 0], ["paddingRight", 4], ["paddingBottom", 0], ["paddingLeft", 4]]))], ["tab", _uM([[".tabs ", _uM([["paddingTop", 0], ["paddingRight", 12], ["paddingBottom", 0], ["paddingLeft", 12], ["position", "relative"], ["display", "flex"], ["flexDirection", "row"], ["alignItems", "center"], ["height", "100%"]])]])], ["tab-indicator", _uM([[".tabs ", _uM([["width", 20], ["height", 3], ["position", "absolute"], ["bottom", 6], ["left", "50%"], ["transform", "translateX(-50%)"], ["zIndex", 1], ["borderTopLeftRadius", 100], ["borderTopRightRadius", 100], ["borderBottomRightRadius", 100], ["borderBottomLeftRadius", 100], ["backgroundColor", "var(--primary-color)"]])]])], ["item-text", _uM([[".tabs ", _uM([["color", "var(--text-color-1)"]])]])], ["item-text-active", _uM([[".tabs ", _uM([["color", "var(--primary-color)"]])]])], ["fab-btn", _pS(_uM([["position", "absolute"], ["right", 16], ["bottom", 16]]))]])]
