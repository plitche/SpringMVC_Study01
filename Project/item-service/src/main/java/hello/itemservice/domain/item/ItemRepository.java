package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
// @Component가 안에 들어있어서 componentScan의 대상이 된다.
public class ItemRepository {

    // 멀티쓰레드 환경에서 여러개가 접근하게 되면 HashMap을 쓰면 안된다.
    // 동시에 여러 쓰레드가 동시에 접근한다.
    // ConcurrentHashMap을 사용해야 한다.
    private static final Map<Long, Item> store = new HashMap<>(); // static
    private static long sequence = 0L; // static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); // 한번 list로 감싸는 이유는 ArrayList를 추가하거나 하더라도 store 자체는 변하지 않기 때문
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
