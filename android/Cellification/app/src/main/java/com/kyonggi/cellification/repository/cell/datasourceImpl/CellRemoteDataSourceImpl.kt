package com.kyonggi.cellification.repository.cell.datasourceImpl

import com.kyonggi.cellification.data.model.cell.Cell
import com.kyonggi.cellification.data.model.cell.RequestCell
import com.kyonggi.cellification.data.model.cell.ResponseCell
import com.kyonggi.cellification.data.model.cell.ResponseSpecificUserCell
import com.kyonggi.cellification.data.remote.service.CellService

import com.kyonggi.cellification.repository.cell.datasource.CellRemoteDataSource
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject

class CellRemoteDataSourceImpl(
    private val cellService: CellService
): CellRemoteDataSource {
    override suspend fun makeCell(token:String, requestCell: RequestCell, userid: String): Response<ResponseCell> {
        return cellService.makeCell(token, requestCell, userid)
    }

    override suspend fun getCellListFromUser(token:String, userid: String): Response<List<ResponseCell>>{
        return cellService.getCellListFromUser(token, userid)
    }

    override suspend fun getCellInfoFromCellID(cellid: String): Response<ResponseCell> {
       return cellService.getCellInfoFromCellID(cellid)
    }

    override suspend fun deleteAllCell(userid: String): Response<Void> {
        return cellService.deleteAllCell(userid)
    }

    override suspend fun deleteSpecificCell(userid: String, cellid: String): Response<Void> {
        return cellService.deleteSpecificCell(userid,cellid)
    }


}
