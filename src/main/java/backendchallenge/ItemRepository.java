package backendchallenge;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends Repository<Item, Long> {

    // for user story 1 : admin can add an item
    Item save(Item item);
    
    // for user story 2 : admin can list all items
    Page<Item> findAll(Pageable pageable);
    
    // for user story 3 : guest can search items by content
    @Query("select i from Item i where "
            + "lower(i.question) like lower(concat('%', :text, '%'))"
            + " or lower(i.answer) like lower(concat('%', :text, '%'))"
            + " or lower(i.tags) like lower(concat('%', :text, '%'))")
    List<Item> findByText(@Param("text") String text);
    

}
