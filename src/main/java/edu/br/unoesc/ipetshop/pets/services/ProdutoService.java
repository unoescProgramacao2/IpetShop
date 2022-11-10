package edu.br.unoesc.ipetshop.pets.services;


import edu.br.unoesc.ipetshop.pets.dtos.ProdutoDTO;
import edu.br.unoesc.ipetshop.pets.entities.Categoria;
import edu.br.unoesc.ipetshop.pets.entities.Produto;
import edu.br.unoesc.ipetshop.pets.repositories.CategoriaRepository;
import edu.br.unoesc.ipetshop.pets.repositories.ProdutoRepository;
import edu.br.unoesc.ipetshop.util.Phraseology;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.time.Period.*;

@Service
public class ProdutoService {

    final
    ProdutoRepository produtoRepository;

    final
    CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }
    @Transactional
    public ProdutoDTO salvarNovoProduto(@NotNull ProdutoDTO produtoDTO) {

        Produto produtoQueVaiSerGravado;

        if(produtoDTO.getId()!=null){
            Produto verificaSeExisteProduto = produtoRepository.findById(produtoDTO.getId());
            if(verificaSeExisteProduto!=null)
                throw new RuntimeException(Phraseology.MENSAGEM_PRODUTO_EXISTENTE);

        }

        produtoQueVaiSerGravado = new Produto();

        return this.registrarProduto(produtoQueVaiSerGravado,produtoDTO);
    }
    public List<ProdutoDTO> listarTodos(){
        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        List<Produto> produtos= produtoRepository.findAll();
        produtos.forEach(produto -> {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtosDTO.add(produtoDTO);
        });
        return produtosDTO;
    }

    public ProdutoDTO buscaProdutoPorId(Long produtoId){
        Produto produto = produtoRepository.findById(produtoId);
        if(produto==null)
            throw new RuntimeException(Phraseology.MENSAGEM_PRODUTO_NAO_EXISTE);
        return new ProdutoDTO();
    }



    public ProdutoDTO atualizarProduto(ProdutoDTO produtoDTO) {

        if(produtoDTO.getId()==null)
            throw new RuntimeException(Phraseology.MENSAGEM_PRODUTO_NAO_EXISTE);

        Produto produtoQueVaiSerAtualizado = produtoRepository.findById(produtoDTO.getId());

        if(produtoQueVaiSerAtualizado==null){
            throw new RuntimeException(Phraseology.MENSAGEM_PRODUTO_NAO_EXISTE);
        }

        boolean podeAlterar = this.validarAlteracaoProduto(produtoQueVaiSerAtualizado,Phraseology.PRAZO_EM_DIAS_PARA_ALTERACAO);

        if(podeAlterar) {

            produtoQueVaiSerAtualizado.setDataAtualizacao(LocalDateTime.now());

            return this.registrarProduto(produtoQueVaiSerAtualizado,produtoDTO);

        } else throw new RuntimeException(Phraseology.MENSAGEM_NAO_PODE_ALTERAR_PRODUTO);


    }

    public void deletarProduto(Long produtoId){

        Produto produtoQueVaiSerDeletado = produtoRepository.findById(produtoId);

        if(produtoQueVaiSerDeletado==null){
            throw new RuntimeException(Phraseology.MENSAGEM_PRODUTO_NAO_EXISTE);
        }

        boolean podeAlterar = this.validarAlteracaoProduto(produtoQueVaiSerDeletado,Phraseology.PRAZO_EM_DIAS_PARA_ALTERACAO);

        if(podeAlterar) {

            produtoQueVaiSerDeletado.setDataAtualizacao(LocalDateTime.now());

            this.produtoRepository.delete(produtoQueVaiSerDeletado);
        } else throw new RuntimeException(Phraseology.MENSAGEM_NAO_PODE_ALTERAR_PRODUTO);

    }

    private ProdutoDTO registrarProduto(Produto produtoQueVaiSerGravado, ProdutoDTO produtoDTO ){
        Categoria categoria;
        try{
            categoria = categoriaRepository.findById(produtoDTO.getCategoriaId());

            if(categoria==null)
                throw new RuntimeException(Phraseology.MENSAGEM_CATEGORIA_NAO_EXISTE);

            produtoQueVaiSerGravado.setCategoria(categoria);



        }catch (Exception e) {
            throw new RuntimeException(Phraseology.MENSAGEM_CATEGORIA_NAO_EXISTE);
        }

        produtoQueVaiSerGravado.setNome(produtoDTO.getNome());
        produtoQueVaiSerGravado.setDescricao(produtoDTO.getDescricao());
        produtoQueVaiSerGravado.setValor(produtoDTO.getValor());
        produtoQueVaiSerGravado.setMarca(produtoDTO.getMarca());
        produtoQueVaiSerGravado.setSituacao(produtoDTO.getSituacao());
        produtoQueVaiSerGravado.setUnidade(produtoDTO.getUnidade());

        produtoRepository.save(produtoQueVaiSerGravado);
        produtoDTO.setId(produtoQueVaiSerGravado.getId());
        produtoDTO.setCategoria(categoria.getNome());

        return  produtoDTO;
    }

    private boolean validarAlteracaoProduto(Produto produto, int prazoEmDiasParaAlteracao){

        Period diff = between(produto.getDataCriacao().toLocalDate(),
                LocalDate.now());
        return (diff.getDays()<=prazoEmDiasParaAlteracao) ? true : false;

    }


}
