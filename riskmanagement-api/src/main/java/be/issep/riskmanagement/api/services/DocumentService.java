package be.issep.riskmanagement.api.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import be.issep.riskmanagement.api.entities.Choice;
import be.issep.riskmanagement.api.entities.Document;
import be.issep.riskmanagement.api.entities.dtos.DocumentDTO;
import be.issep.riskmanagement.api.repositories.DocumentRepository;

@Service
public class DocumentService implements be.issep.riskmanagement.api.services.Service<Document, DocumentDTO, Long> {

	@Autowired
	private DocumentRepository repository;
	@Autowired
	private ChoiceService choiceService;
  
  @Value("${document.directory}")
  private String directory;

	@Override
	public Document get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public List<Document> all() {
		return this.repository.findAll();
	}

	@Override
	public Document add(DocumentDTO doc) {
		Choice category = null;
		if(doc.getCategory() != null) {
			category = this.choiceService.get(doc.getCategory());
		}
		Document entity = doc.convert();
		entity.setCategory(category);
		return this.repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	public String upload(MultipartFile file) {
		String path = this.directory + file.getOriginalFilename();
		try {
			byte[] bytes = file.getBytes();
			BufferedOutputStream os = new BufferedOutputStream(
						new FileOutputStream(new File(path))
					);
			os.write(bytes);
			os.close();
		} catch (Exception e) {
			
		}
		return path;
	}
	
	public Resource download(Long id) {
		Document e = this.repository.findById(id).get();
		Path path = Paths.get(e.getFilePath());
		Resource resource = null;
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		return resource;
	}

}
