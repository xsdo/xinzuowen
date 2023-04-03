<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="是否使用" prop="isUsed">
        <el-input
          v-model="queryParams.isUsed"
          placeholder="请输入是否使用"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="视频名" prop="vName">
        <el-input
          v-model="queryParams.vName"
          placeholder="请输入视频名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="视频作者" prop="vTeacher">
        <el-input
          v-model="queryParams.vTeacher"
          placeholder="请输入视频作者"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="作者头衔" prop="vRank">
        <el-input
          v-model="queryParams.vRank"
          placeholder="请输入作者头衔"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="视频描述" prop="vDescription">
        <el-input
          v-model="queryParams.vDescription"
          placeholder="请输入视频描述"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="视频时间" prop="vTime">
        <el-input
          v-model="queryParams.vTime"
          placeholder="请输入视频时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年级" prop="vGrade">
        <el-input
          v-model="queryParams.vGrade"
          placeholder="请输入年级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学期" prop="vTerm">
        <el-input
          v-model="queryParams.vTerm"
          placeholder="请输入学期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单元" prop="vUnitarea">
        <el-input
          v-model="queryParams.vUnitarea"
          placeholder="请输入单元"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['resources:videos:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['resources:videos:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['resources:videos:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['resources:videos:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="videosList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="是否使用" align="center" prop="isUsed" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="视频名" align="center" prop="vName" />
      <el-table-column label="视频作者" align="center" prop="vTeacher" />
      <el-table-column label="视频" align="center" prop="vVideos" />
      <el-table-column label="视频类型" align="center" prop="vType" />
      <el-table-column label="作者头衔" align="center" prop="vRank" />
      <el-table-column label="视频描述" align="center" prop="vDescription" />
      <el-table-column label="视频时间" align="center" prop="vTime" />
      <el-table-column label="年级" align="center" prop="vGrade" />
      <el-table-column label="学期" align="center" prop="vTerm" />
      <el-table-column label="单元" align="center" prop="vUnitarea" />
      <el-table-column label="图片" align="center" prop="vImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.vImage" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['resources:videos:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['resources:videos:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改视频对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="是否使用" prop="isUsed">
          <el-input v-model="form.isUsed" placeholder="请输入是否使用" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="视频名" prop="vName">
          <el-input v-model="form.vName" placeholder="请输入视频名" />
        </el-form-item>
        <el-form-item label="视频作者" prop="vTeacher">
          <el-input v-model="form.vTeacher" placeholder="请输入视频作者" />
        </el-form-item>
        <el-form-item label="视频" prop="vVideos">
          <el-input v-model="form.vVideos" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="作者头衔" prop="vRank">
          <el-input v-model="form.vRank" placeholder="请输入作者头衔" />
        </el-form-item>
        <el-form-item label="视频描述" prop="vDescription">
          <el-input v-model="form.vDescription" placeholder="请输入视频描述" />
        </el-form-item>
        <el-form-item label="视频时间" prop="vTime">
          <el-input v-model="form.vTime" placeholder="请输入视频时间" />
        </el-form-item>
        <el-form-item label="年级" prop="vGrade">
          <el-input v-model="form.vGrade" placeholder="请输入年级" />
        </el-form-item>
        <el-form-item label="学期" prop="vTerm">
          <el-input v-model="form.vTerm" placeholder="请输入学期" />
        </el-form-item>
        <el-form-item label="单元" prop="vUnitarea">
          <el-input v-model="form.vUnitarea" placeholder="请输入单元" />
        </el-form-item>
        <el-form-item label="图片" prop="vImage">
          <image-upload v-model="form.vImage"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listVideos, getVideos, delVideos, addVideos, updateVideos } from "@/api/resources/videos";

export default {
  name: "Videos",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 视频表格数据
      videosList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        isUsed: null,
        remarks: null,
        vName: null,
        vTeacher: null,
        vVideos: null,
        vType: null,
        vRank: null,
        vDescription: null,
        vTime: null,
        vGrade: null,
        vTerm: null,
        vUnitarea: null,
        vImage: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询视频列表 */
    getList() {
      this.loading = true;
      listVideos(this.queryParams).then(response => {
        this.videosList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        isUsed: null,
        createTime: null,
        updateTime: null,
        remarks: null,
        vName: null,
        vTeacher: null,
        vVideos: null,
        vType: null,
        vRank: null,
        vDescription: null,
        vTime: null,
        vGrade: null,
        vTerm: null,
        vUnitarea: null,
        vImage: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加视频";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getVideos(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改视频";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateVideos(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addVideos(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除视频编号为"' + ids + '"的数据项？').then(function() {
        return delVideos(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('resources/videos/export', {
        ...this.queryParams
      }, `videos_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
