package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.TagDTO;
import ro.tuc.ds2020.dtos.builders.TagBuilder;
import ro.tuc.ds2020.entities.Tag;
import ro.tuc.ds2020.repositories.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagDTO> findTags() {
        return tagRepository.findAll()
                .stream()
                .map(TagBuilder::toTagDTO)
                .collect(Collectors.toList());
    }

    public TagDTO findById(Integer id) {
        return tagRepository.findById(id)
                .map(TagBuilder::toTagDTO)
                .orElseThrow(() -> new RuntimeException("Tag with id " + id + " not found"));
    }


    public Integer insert(TagDTO dto) {
        Tag tag = TagBuilder.toEntity(dto);
        return tagRepository.save(tag).getId();
    }

    public void update(Integer id, TagDTO dto) {
        Tag tag = TagBuilder.toEntity(dto);
        tag.setId(id);
        tagRepository.save(tag);
    }

    public void delete(Integer id) {
        tagRepository.deleteById(id);
    }
}
