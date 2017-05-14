package com.mmc.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mmc.entity.AlbumCoverEntity;
import com.mmc.entity.AlbumEntity;
import com.mmc.entity.AlbumInfoEntity;
import com.mmc.entity.AlbumYearEntity;
import com.mmc.model.Album;
import com.mmc.repository.AlbumRepository;

/**
 * Created by SGaurav on 15/12/2016.
 */
@Service
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumRepository albumRepository;

	@Value("${albums.path}")
	private String ALBUMS_LOCATION;

	@Value("${albums.server-image-path}")
	private String SERVER_IMAGE_PATH;

	public void add(Album album) throws Exception{

		String uid = UUID.randomUUID().toString();
		album.setAlbumId(uid);

		albumRepository.save(new AlbumEntity(album));

	}

	public List<Album> get(){
		Iterable<AlbumEntity> albumEntities = albumRepository.findAll();
		List<Album> albumList = new ArrayList<Album>();
		for (AlbumEntity albumEntity: albumEntities){
			albumList.add(new Album(albumEntity));
		}
		return albumList;
	}

	public void rename(Album album){
		albumRepository.save(new AlbumEntity(album));
	}

	public void delete(Album album){
		albumRepository.delete(new AlbumEntity(album));
	}

	@Override
	public List<AlbumYearEntity> getAlbumsInfo() throws Exception {

		List<AlbumYearEntity> albumYearEntityList = new ArrayList<AlbumYearEntity>();
		File imagesBaseDir = new File(ALBUMS_LOCATION);

		for(File yearDir : imagesBaseDir.listFiles()){
			if(yearDir.isDirectory()){
				AlbumYearEntity ae =  new AlbumYearEntity();
				albumYearEntityList.add(ae);
				ae.setYearNumber(yearDir.getName());
				List<AlbumCoverEntity> albumsList = new ArrayList<AlbumCoverEntity>();
				ae.setAlbumsList(albumsList);
				for(File albumDir : yearDir.listFiles()){
					if(albumDir.isDirectory()){
						AlbumCoverEntity albumCoverEntity = new AlbumCoverEntity();
						albumsList.add(albumCoverEntity);
						albumCoverEntity.setName(albumDir.getName());
						albumCoverEntity.setThumbnailPath(SERVER_IMAGE_PATH+'/'+yearDir.getName()+'/'+albumDir.getName()+"/thumbnail.jpg");
					}
				}
			}
		}
		return albumYearEntityList;

	}

	@Override
	public AlbumInfoEntity getAlbumImagePaths(String albumName, String year) throws Exception {
		AlbumInfoEntity albumInfoEntity = new AlbumInfoEntity();
		String yearAlbumPath = '/'+year+'/'+albumName;
		List<String> albumImagePaths = new ArrayList<>();
		albumInfoEntity.setAlbumImagePaths(albumImagePaths);
		File albumDir = new File(ALBUMS_LOCATION+yearAlbumPath); 
		if(albumDir.exists() && albumDir.isDirectory()){
			albumInfoEntity.setAlbumName(albumName);
			for(File image : albumDir.listFiles()){
				albumImagePaths.add(SERVER_IMAGE_PATH+yearAlbumPath+'/'+image.getName());
			}
			return albumInfoEntity;
		}
		return null;
	}
}
