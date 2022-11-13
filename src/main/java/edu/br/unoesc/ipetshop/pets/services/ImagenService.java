package edu.br.unoesc.ipetshop.pets.services;

import edu.br.unoesc.ipetshop.pets.dtos.ImagensDTO;
import edu.br.unoesc.ipetshop.pets.entities.Imagen;
import edu.br.unoesc.ipetshop.pets.entities.Produto;
import edu.br.unoesc.ipetshop.pets.repositories.ImagenRepository;
import edu.br.unoesc.ipetshop.pets.repositories.ProdutoRepository;
import edu.br.unoesc.ipetshop.util.Phraseology;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ImagenService {
    final
    ProdutoRepository produtoRepository;
    final
    ImagenRepository imagenRepository;

    public ImagenService(ImagenRepository imagenRepository, ProdutoRepository produtoRepository) {
        this.imagenRepository = imagenRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<ImagensDTO> listarTodasImagensPorProduto(Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId);
        if (produto == null)
            throw new RuntimeException(Phraseology.MENSAGEM_PRODUTO_NAO_EXISTE);
        List<ImagensDTO> imagensDTO = new ArrayList<>();
        for (Imagen imagen : produto.getImagens()) {
            imagensDTO.add(new ImagensDTO(imagen));
        }
        return imagensDTO;
    }
    public ImagensDTO buscaImagenPorId(Long imagenId, Long produtoId){
        Imagen imagen = imagenRepository.findByProdutoAndId(produtoId,imagenId);
        if(imagen==null)
            throw new RuntimeException(Phraseology.IMAGEM_NAO_EXISTE);
        return new ImagensDTO(imagen);
    }

    public ImagensDTO salvarNovaImagen(Long produtoId, ImagensDTO novaimagensDTO) {
        Imagen imagem = new Imagen();
        imagem.setNome(novaimagensDTO.getNome());
        imagem.setUrlarquivo(novaimagensDTO.getUrlarquivo());
        Produto produto = produtoRepository.findById(produtoId);
        imagem.setProduto(produto);
        imagem = imagenRepository.save(imagem);
        novaimagensDTO.setId(imagem.getId());
        novaimagensDTO.setProdutoId(produtoId);
        return novaimagensDTO;
    }

    public ImagensDTO atualizarImagen(Long produtoId, ImagensDTO imagenAtualizadaDTO) {
        try {
            Imagen imagen = imagenRepository.findByProdutoAndId(produtoId, imagenAtualizadaDTO.getId());
            if (imagen == null)
                throw new RuntimeException(Phraseology.IMAGEM_NAO_EXISTE);
            imagen.setNome(imagenAtualizadaDTO.getNome());
            imagen.setDataAtualizacao(LocalDateTime.now());
            imagen.setUrlarquivo(imagenAtualizadaDTO.getUrlarquivo());
            imagen = imagenRepository.save(imagen);
            imagenAtualizadaDTO.setId(imagen.getId());
            return imagenAtualizadaDTO;
        } catch (Exception e) {
            throw new RuntimeException(Phraseology.IMAGEM_NAO_PODE_SER_ALTERADA);
        }
    }

    public void deletarImagen(Long produtoId, Long imagenId) {
        Imagen imagen = imagenRepository.findByProdutoAndId(produtoId, imagenId);
        if (imagen == null)
            throw new RuntimeException(Phraseology.IMAGEM_NAO_EXISTE);
        imagenRepository.delete(imagen);
    }
}
