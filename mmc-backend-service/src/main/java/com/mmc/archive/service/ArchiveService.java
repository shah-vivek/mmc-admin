package com.mmc.archive.service;

import com.mmc.archive.dao.IDocumentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A service to save, find and get documents from an archive. 
 * 
 * @author Daniel Murygin <daniel.murygin[at]gmail[dot]com>
 */
@Service("archiveService")
public class ArchiveService implements IArchiveService, Serializable {

    private static final long serialVersionUID = 8119784722798361327L;
    
    @Autowired
    private IDocumentDao DocumentDao;

    /**
     * Saves a document in the archive.
     * @see com.mmc.archive.service.IArchiveService#save(com.mmc.archive.service.Document)
     */
    @Override
    public DocumentMetadata save(Document document) {
        getDocumentDao().insert(document); 
        return document.getMetadata();
    }
    
    /**
     * Finds document in the archive
     * @see com.mmc.archive.service.IArchiveService#findDocuments(java.lang.String, java.util.Date)
     */
    @Override
    public List<DocumentMetadata> findDocuments(String personName, Date date) {
        return getDocumentDao().findByPersonNameDate(personName, date);
    }
    
    /**
     * Returns the document file from the archive
     * @see com.mmc.archive.service.IArchiveService#getDocumentFile(java.lang.String)
     */
    @Override
    public byte[] getDocumentFile(String id) {
        Document document = getDocumentDao().load(id);
        if(document!=null) {
            return document.getFileData();
        } else {
            return null;
        }
    }

    @Override
    public List<byte[]> getAlbumFiles(String albumId) {
        List<Document> list = getDocumentDao().albumsDoc(albumId);
        List<byte[]> fileList = new ArrayList<byte[]>();
        for (Document doc: list
                ) {
            fileList.add(doc.getFileData());
        }
        return fileList;
    }

    public IDocumentDao getDocumentDao() {
        return DocumentDao;
    }

    public void setDocumentDao(IDocumentDao documentDao) {
        DocumentDao = documentDao;
    }


}
