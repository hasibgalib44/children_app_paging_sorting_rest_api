package controller;


import com.example.springapp.model.Children;
import com.example.springapp.service.ChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/children")
@CrossOrigin("*")  // allows frontend (React/Angular) access if needed
public class ChildrenController {

    @Autowired
    private ChildrenService childrenService;

    // ✅ Create (POST)
    @PostMapping
    public String saveChildren(@RequestBody Children child) {
        childrenService.saveChildren(child);
        return "Child record saved successfully!";
    }

    // ✅ Get all children sorted by a specific field (ascending)
    @GetMapping("/sort/{field}")
    public List<Children> getChildrenSortedByField(@PathVariable String field) {
        return childrenService.getChildrenSortedByField(field);
    }

    // ✅ Get children with pagination (offset, page size)
    @GetMapping("/{offset}/{pagesize}")
    public Page<Children> getChildrenWithPagination(
            @PathVariable int offset,
            @PathVariable int pagesize) {
        return childrenService.getChildrenOffsetWithPageSize(offset, pagesize);
    }

    // ✅ Get children with pagination and sorting
    @GetMapping("/{offset}/{pagesize}/{field}")
    public Page<Children> getChildrenWithPaginationAndSorting(
            @PathVariable int offset,
            @PathVariable int pagesize,
            @PathVariable String field) {
        return childrenService.getChildrenOffsetWithPageSizeSortedByField(offset, pagesize, field);
    }
}


